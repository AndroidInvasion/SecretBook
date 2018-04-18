package ru.androidinvasion.secretbook.view.reader.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.androidinvasion.secretbook.App
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.data.api.Book
import ru.androidinvasion.secretbook.di.reader.ReaderModule
import ru.androidinvasion.secretbook.interactor.reader.IReaderInteractor
import ru.androidinvasion.secretbook.view.reader.ui.IReaderView
import ru.androidinvasion.secretbook.view.reader.ui.ReaderAction
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 15.04.18
 */

@InjectViewState
class ReaderPresenter : MvpPresenter<IReaderView>() {
    private var currentBook: Book? = null
    @Inject
    lateinit var interactor: IReaderInteractor
    private var disposable = CompositeDisposable()

    init {
        App.appComponent.plus(ReaderModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.notifyPresenterAboutAction()
    }

    fun openReader(action: ReaderAction) {
        when (action) {
            ReaderAction.RANDOM -> openRandom()
        }
    }

    fun onNextClick() {
        openRandom()
    }

    fun onBuyClick() {
        val tmpBook = currentBook
        if (tmpBook == null || tmpBook.stores.isEmpty()) {
            return
        }
        viewState.openUrl(tmpBook.stores.first().storeurl)
    }

    private fun openRandom() {
        viewState.setProgress(true)
        disposable.addAll(interactor.getRandomBook().observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.setBook(it.toReaderBook())
                    currentBook = it
                    viewState.setProgress(false)
                }, {
                    Timber.e(it)
                    viewState.setProgress(false)
                    viewState.showError(R.string.reader_error)
                }))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}