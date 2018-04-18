package ru.androidinvasion.secretbook.view.genresscreen.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.androidinvasion.secretbook.data.genresscreen.Genre

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 16.04.18
 */

@StateStrategyType(AddToEndSingleStrategy::class)
interface GenresView : MvpView {
    fun setGenresList(genres: List<Genre>)
    fun setProgress(visible: Boolean)
    fun onError(resId: Int)
    fun openMainScreen()
}