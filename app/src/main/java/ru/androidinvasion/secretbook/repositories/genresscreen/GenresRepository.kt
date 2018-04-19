package ru.androidinvasion.secretbook.repositories.genresscreen

import android.content.SharedPreferences
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import ru.androidinvasion.secretbook.data.api.Api
import ru.androidinvasion.secretbook.data.api.Genre

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 15.04.18
 */
class GenresRepository(private val sharedPreferences: SharedPreferences, retrofit: Retrofit) : IGenresRepository {
    private val api = retrofit.create(Api::class.java)

    override fun getAllGenres(): Single<List<Genre>> {
        return api.getTags().subscribeOn(Schedulers.io())
    }

    override fun getMyGenres(): List<Genre> {
        return sharedPreferences.getStringSet("genres", emptySet()).toList().map { Genre(it) }
    }

    override fun setMyGenres(list: List<Genre>): Completable {
        return Completable.fromCallable {
            sharedPreferences.edit().putStringSet("genres", list.map { it.toString() }.toMutableSet()).apply()
        }.subscribeOn(Schedulers.io())
    }
}