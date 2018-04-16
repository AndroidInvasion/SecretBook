package ru.androidinvasion.secretbook.view.reader.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.androidinvasion.secretbook.view.reader.ui.IReaderView
import ru.androidinvasion.secretbook.view.reader.ui.ReaderAction

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 15.04.18
 */

@InjectViewState
class ReaderPresenter : MvpPresenter<IReaderView>() {
    fun openReader(action: ReaderAction) {

    }
}