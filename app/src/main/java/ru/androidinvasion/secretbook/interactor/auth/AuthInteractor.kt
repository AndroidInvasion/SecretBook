package ru.androidinvasion.secretbook.interactor.auth

import io.reactivex.Single
import ru.androidinvasion.secretbook.data.auth.UserModel
import ru.androidinvasion.secretbook.repositories.auth.IAuthRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class AuthInteractor(private val authRepository: IAuthRepository) : IAuthInteractor {
    override fun getToken(): String? {
        return authRepository.getToken()
    }

    override fun login(login: String, password: String): Single<UserModel> {
        return authRepository.login(login, password)
    }
}