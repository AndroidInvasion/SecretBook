package ru.androidinvasion.secretbook.view.main.presenter

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.data.api.*
import ru.androidinvasion.secretbook.interactor.genres.IGenresInteractor
import ru.androidinvasion.secretbook.view.genresscreen.presenter.GenresPresenter
import ru.androidinvasion.secretbook.view.main.ui.MainView
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var genresInteractor: IGenresInteractor
    private lateinit var selectedGenres: HashSet<Genre>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        genresInteractor.getAllGenres()
                .observeOn(AndroidSchedulers.mainThread())
                .retry(GenresPresenter.RETRY_COUNT)
                .subscribe({
                    selectedGenres = HashSet(it)
                }, {
                    selectedGenres = HashSet()
                    viewState.onError(R.string.genres_error)
                })
        viewState.setSelectedGenres(selectedGenres)
    }

    fun onGenreSelect(genre: Genre) {
        selectedGenres.add(genre)
        viewState.setSelectedGenres(selectedGenres)
    }

    fun onGenreDelete(genre: Genre) {
        selectedGenres.remove(genre)
        viewState.setSelectedGenres(selectedGenres)
    }

    fun onClickRandomBook() {
        genresInteractor.setMyGenres(ArrayList(selectedGenres))
        viewState.openReader()
    }

    fun getHistory(): List<Book> {
        return listOf(Book(0, "", Author(), "myBook", "",
                emptyArray<Author>(), Author(), 0, "",
                emptyArray<Store>(), emptyArray<Genre>(), emptyArray<Library>(), 2018))
    }
}