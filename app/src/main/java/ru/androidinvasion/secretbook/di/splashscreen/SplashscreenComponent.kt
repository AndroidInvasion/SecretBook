package ru.androidinvasion.secretbook.di.splashscreen

import dagger.Subcomponent
import ru.androidinvasion.secretbook.view.splashscreen.presenter.SplashscreenPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@Subcomponent(modules = [SplashscreenModule::class])
@SplashscreenScope
interface SplashscreenComponent {
    fun inject(presenter: SplashscreenPresenter)
}