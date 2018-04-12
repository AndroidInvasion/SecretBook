package ru.androidinvasion.secretbook.view.splashscreen.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.androidinvasion.secretbook.App
import ru.androidinvasion.secretbook.di.splashscreen.SplashscreenModule
import ru.androidinvasion.secretbook.interactor.splashscreen.ISplashscreenInteractor
import ru.androidinvasion.secretbook.view.splashscreen.ui.ISplashscreenView
import javax.inject.Inject

@InjectViewState
class SplashscreenPresenter : MvpPresenter<ISplashscreenView>() {
    @Inject
    lateinit var splashscreenInteractor: ISplashscreenInteractor

    init {
        App.appComponent.plus(SplashscreenModule()).inject(this)
    }

    fun loadUpdates(){
        viewState.setUpdates(splashscreenInteractor.getUpdates())
    }

}