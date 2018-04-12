package ru.androidinvasion.secretbook.di.auth

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.androidinvasion.secretbook.interactor.auth.AuthInteractor
import ru.androidinvasion.secretbook.interactor.auth.IAuthInteractor
import ru.androidinvasion.secretbook.repositories.auth.AuthRepository
import ru.androidinvasion.secretbook.repositories.auth.IAuthRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@Module
@AuthScope
class AuthModule {
    @Provides
    @AuthScope
    fun provideRepository(sharedPreferences: SharedPreferences): IAuthRepository {
        return AuthRepository(sharedPreferences)
    }


    @Provides
    @AuthScope
    fun provideInteractor(authRepository: IAuthRepository): IAuthInteractor {
        return AuthInteractor(authRepository)
    }
}