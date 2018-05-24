package ru.androidinvasion.secretbook.interactor.reader

import io.reactivex.Single
import ru.androidinvasion.secretbook.data.api.Book

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

interface IReaderInteractor {
    fun getRandomBook(): Single<Book>
    fun onBookReaded(book: Book)
}