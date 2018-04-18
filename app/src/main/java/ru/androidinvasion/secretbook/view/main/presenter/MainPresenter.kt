package ru.androidinvasion.secretbook.view.main.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.androidinvasion.secretbook.view.main.ui.MainView

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    fun onClickRandomBook() {
        viewState.openRandomBook()
    }
}