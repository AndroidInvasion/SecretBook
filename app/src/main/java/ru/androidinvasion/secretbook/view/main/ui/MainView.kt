package ru.androidinvasion.secretbook.view.main.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.androidinvasion.secretbook.data.api.Genre

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

interface MainView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun openReader()
    fun onError(error_id: Int)
    fun setSelectedGenres(selectedGenres: HashSet<Genre>)
}