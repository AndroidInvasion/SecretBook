package ru.androidinvasion.secretbook.interactor.splashscreen

import ru.androidinvasion.secretbook.data.splashscreen.UpdateModel


/**
 * Created by egor on 04.04.18.
 */
interface ISplashscreenInteractor {
    fun getUpdates():List<UpdateModel>
}