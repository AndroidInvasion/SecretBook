package ru.androidinvasion.secretbook.view.reader.ui

import com.arellomobile.mvp.MvpView
import ru.lionzxy.yetanotherreaderlibrary.data.Book

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 15.04.18
 */

interface IReaderView : MvpView {
    fun setBook(book: Book)
}