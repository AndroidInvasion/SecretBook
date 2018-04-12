package ru.androidinvasion.secretbook.di.splashscreen

import dagger.Module
import dagger.Provides
import ru.androidinvasion.secretbook.interactor.splashscreen.ISplashscreenInteractor
import ru.androidinvasion.secretbook.interactor.splashscreen.SplashscreenInteractor
import ru.androidinvasion.secretbook.repositories.splashscreen.ISplashscreenRepository
import ru.androidinvasion.secretbook.repositories.splashscreen.SplashscreenRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@Module
@SplashscreenScope
class SplashscreenModule {
    @Provides
    @SplashscreenScope
    fun provideRepository(): ISplashscreenRepository {
        return SplashscreenRepository()
    }


    @Provides
    @SplashscreenScope
    fun provideInteractor(splashscreenRepository: ISplashscreenRepository): ISplashscreenInteractor {
        return SplashscreenInteractor(splashscreenRepository)
    }
}