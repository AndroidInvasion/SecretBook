package ru.androidinvasion.secretbook.interactor.splashscreen


import ru.androidinvasion.secretbook.data.splashscreen.UpdateModel
import ru.androidinvasion.secretbook.repositories.splashscreen.ISplashscreenRepository


/**
 * Created by egor on 04.04.18.
 */
class SplashscreenInteractor(private val splashscreenRepository: ISplashscreenRepository) : ISplashscreenInteractor {
    override fun getUpdates(): List<UpdateModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}