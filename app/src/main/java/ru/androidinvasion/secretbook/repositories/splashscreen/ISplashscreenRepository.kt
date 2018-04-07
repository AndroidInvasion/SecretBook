package ru.androidinvasion.secretbook.repositories.splashscreen

import ru.androidinvasion.secretbook.data.splashscreen.UpdateModel

/**
 * Created by egor on 04.04.18.
 */
interface ISplashscreenRepository {

    fun getUpdates() : List<UpdateModel>

}