package ru.androidinvasion.secretbook.di.main

import dagger.Subcomponent
import ru.androidinvasion.secretbook.view.main.presenter.MainPresenter

/**
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

@Subcomponent(modules = [MainModule::class])
@MainScope
interface MainComponent {
    fun inject(presenter: MainPresenter)
}