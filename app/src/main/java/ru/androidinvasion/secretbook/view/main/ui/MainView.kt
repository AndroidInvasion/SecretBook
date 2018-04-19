package ru.androidinvasion.secretbook.view.main.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

interface MainView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun openRandomBook()
}