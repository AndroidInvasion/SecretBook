package ru.androidinvasion.secretbook

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import ru.androidinvasion.secretbook.di.app.AppComponent
import ru.androidinvasion.secretbook.di.app.AppModule
import ru.androidinvasion.secretbook.di.app.DaggerAppComponent

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 05.03.18
 */
class App : Application() {
    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}