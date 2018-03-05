package ru.androidinvasion.secretbook

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 05.03.18
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
    }
}