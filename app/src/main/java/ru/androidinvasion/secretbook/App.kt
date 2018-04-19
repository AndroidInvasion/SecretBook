package ru.androidinvasion.secretbook

import android.app.Application
import android.os.StrictMode
import com.crashlytics.android.Crashlytics
import com.squareup.leakcanary.LeakCanary
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

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)

        val cras = Crashlytics()

        Fabric.with(this, cras)

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build())
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())
        }
    }


}