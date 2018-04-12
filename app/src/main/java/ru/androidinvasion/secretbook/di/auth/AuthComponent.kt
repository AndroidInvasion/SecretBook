package ru.androidinvasion.secretbook.di.auth

import dagger.Subcomponent
import ru.androidinvasion.secretbook.view.auth.presenter.AuthPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@Subcomponent(modules = [AuthModule::class])
@AuthScope
interface AuthComponent {
    fun inject(presenter: AuthPresenter)
}