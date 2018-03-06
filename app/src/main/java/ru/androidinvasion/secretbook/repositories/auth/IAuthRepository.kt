package ru.androidinvasion.secretbook.repositories.auth

import io.reactivex.Single
import ru.androidinvasion.secretbook.data.auth.UserModel

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

interface IAuthRepository {
    fun getToken(): String?

    fun login(login: String, password: String): Single<UserModel>
}