package ru.androidinvasion.secretbook.utils

import org.intellij.lang.annotations.Language
import java.util.regex.Pattern

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

object Constants {
    @Language("RegExp")
    val LOGIN_PATTERN: Pattern = Pattern.compile("([a-zA-Z0-9]+)")
    const val PASSWORD_MAX_LENGHT = 4
    const val EXTRA_FIRSTRUN = "firstrun"
    const val EXTRA_INTROENUM = "introenum"

    const val API_URL = "http://78.155.219.3:8080/v1/"
}