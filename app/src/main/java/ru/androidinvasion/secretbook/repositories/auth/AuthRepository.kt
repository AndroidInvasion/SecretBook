package ru.androidinvasion.secretbook.repositories.auth

import android.content.SharedPreferences
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.androidinvasion.secretbook.data.auth.UserModel
import java.util.concurrent.TimeUnit

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class AuthRepository(private val sharedPreferences: SharedPreferences) : IAuthRepository {
    override fun getToken(): String? {
        val token = sharedPreferences.getString("auth_token", "")

        return if (token.isNullOrEmpty()) {
            null
        } else token
    }

    private fun putToken(token: String) {
        sharedPreferences.getString("auth_token", token)
    }

    override fun login(login: String, password: String): Single<UserModel> {
        return Single.fromCallable {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1))
            return@fromCallable UserModel("TestUser", "example@example.com")
        } // Эмуляция запроса с сети
                .subscribeOn(Schedulers.io())
                .doAfterSuccess {
                    putToken("") // Вставляем токен, если успешно
                }
    }
}