package ru.androidinvasion.secretbook.repositories.reader

import io.reactivex.Observable
import io.reactivex.Single
import ru.androidinvasion.secretbook.data.api.Book
import ru.androidinvasion.secretbook.data.api.Genre

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

interface IReaderRepository {
    fun getRandomBooks(genres: List<Genre>, size: Int = 1): Single<List<Book>>
}