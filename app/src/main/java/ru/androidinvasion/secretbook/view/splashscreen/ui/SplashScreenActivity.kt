package ru.androidinvasion.secretbook.view.splashscreen.ui

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.preference.PreferenceManager
import ru.androidinvasion.secretbook.view.intro.ui.IntroActivity

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 12.04.18
 */

class SplashScreenActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preference = PreferenceManager.getDefaultSharedPreferences(this)
        if (preference.getBoolean("firstrun", true)) {
            val intent = Intent(this, IntroActivity::class.java)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            //TODO(preference.edit().putBoolean("firstrun", false).apply())
        } else {
            //TODO(do nothing, lol)
        }
    }

}