package ru.androidinvasion.secretbook.view.genresscreen.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.androidinvasion.secretbook.App
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.data.genresscreen.Genre
import ru.androidinvasion.secretbook.di.genres.GenresModule
import ru.androidinvasion.secretbook.interactor.genres.IGenresInteractor
import ru.androidinvasion.secretbook.view.genresscreen.ui.GenresView
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 16.04.18
 */

@InjectViewState
class GenresPresenter : MvpPresenter<GenresView>() {
    @Inject
    lateinit var interactor: IGenresInteractor
    private var displosable = CompositeDisposable()

    init {
        App.appComponent.plus(GenresModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setProgress(true)
        displosable.addAll(interactor
                .getAllGenres()
                .observeOn(AndroidSchedulers.mainThread())
                .retry(3)
                .subscribe({
                    viewState.setGenresList(it)
                    viewState.setProgress(false)
                }, {
                    viewState.setProgress(false)
                    viewState.onError(R.string.genres_error)
                    Log.e(GenresPresenter::class.java.simpleName, "Error while get genres", it)
                }))
    }

    fun onGenreSelect(genre: Genre) {
        genre.isSelected = true
    }

    fun onGenreDeselect(genre: Genre) {
        genre.isSelected = false
    }

    override fun onDestroy() {
        super.onDestroy()
        displosable.clear()
    }

}