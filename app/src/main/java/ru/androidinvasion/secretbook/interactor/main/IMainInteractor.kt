package ru.androidinvasion.secretbook.interactor.main

import io.reactivex.Single
import ru.androidinvasion.secretbook.data.api.Book
import ru.androidinvasion.secretbook.data.api.Genre

/**
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

interface IMainInteractor {
    fun setMyGenres(genres: List<Genre>)
    fun getAllGenres(): Single<List<Genre>>
    fun addReadedBook(book: Book)
    fun getReadingHistory(): List<Book>
}