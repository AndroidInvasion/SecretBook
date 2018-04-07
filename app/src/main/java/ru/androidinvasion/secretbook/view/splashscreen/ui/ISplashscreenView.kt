package ru.androidinvasion.secretbook.view.splashscreen.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.androidinvasion.secretbook.data.splashscreen.UpdateModel

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@StateStrategyType(AddToEndSingleStrategy::class)
interface ISplashscreenView : MvpView {
    fun setUpdates(updates:List<UpdateModel>)

}