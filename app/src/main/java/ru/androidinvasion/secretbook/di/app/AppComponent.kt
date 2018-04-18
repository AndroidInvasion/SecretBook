package ru.androidinvasion.secretbook.di.app

import dagger.Component
import ru.androidinvasion.secretbook.di.auth.AuthComponent
import ru.androidinvasion.secretbook.di.auth.AuthModule
import ru.androidinvasion.secretbook.di.genres.GenresComponent
import ru.androidinvasion.secretbook.di.genres.GenresModule
import ru.androidinvasion.secretbook.di.reader.ReaderComponent
import ru.androidinvasion.secretbook.di.reader.ReaderModule
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
    fun plus(module: GenresModule): GenresComponent
    fun plus(module: ReaderModule): ReaderComponent
}