package ru.androidinvasion.secretbook.repositories.reader

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import ru.androidinvasion.secretbook.data.api.Api
import ru.androidinvasion.secretbook.data.api.Book
import ru.androidinvasion.secretbook.data.api.Genre

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

class ReaderRepository(retrofit: Retrofit) : IReaderRepository {
    var api = retrofit.create(Api::class.java)!!

    override fun getRandomBooks(genres: List<Genre>, size: Int): Single<List<Book>> {
        return api.getRandomBook(size, genres.map { it.id }.joinToString(","))
                .subscribeOn(Schedulers.io())
    }

}