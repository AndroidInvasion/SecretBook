package ru.androidinvasion.secretbook

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import retrofit2.Retrofit
import ru.androidinvasion.secretbook.di.app.AppComponent
import ru.androidinvasion.secretbook.di.app.AppModule
import ru.androidinvasion.secretbook.di.app.DaggerAppComponent
import ru.androidinvasion.secretbook.utils.Api
import retrofit2.converter.gson.GsonConverterFactory
import ru.androidinvasion.secretbook.utils.Constants.API_URL
import ru.androidinvasion.secretbook.utils.Constants.BACKEND_URL


/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 05.03.18
 */
class App : Application() {
    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent

        lateinit var api: Api
    }

    private lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(Api::class.java)
    }


}