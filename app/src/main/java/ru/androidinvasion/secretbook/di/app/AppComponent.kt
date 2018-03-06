package ru.androidinvasion.secretbook.di.app

import dagger.Component
import ru.androidinvasion.secretbook.di.auth.AuthComponent
import ru.androidinvasion.secretbook.di.auth.AuthModule
import javax.inject.Singleton

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */
@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun plus(module: AuthModule): AuthComponent
}