package ru.androidinvasion.secretbook.view.reader.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.lionzxy.yetanotherreaderlibrary.data.Book

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 15.04.18
 */

@StateStrategyType(AddToEndSingleStrategy::class)
interface IReaderView : MvpView {
    fun setBook(book: Book)
    fun setProgress(visible: Boolean)
    @StateStrategyType(SkipStrategy::class)
    fun notifyPresenterAboutAction()
    @StateStrategyType(SkipStrategy::class)
    fun showError(resId: Int)
    @StateStrategyType(SkipStrategy::class)
    fun openUrl(url: String)
}