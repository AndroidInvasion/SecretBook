package ru.androidinvasion.secretbook.data.auth

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class UserModel(val login: String, val email: String) {
    companion object {
        const val EXTRA_AUTHTOKEN = "auth_token"
    }
}