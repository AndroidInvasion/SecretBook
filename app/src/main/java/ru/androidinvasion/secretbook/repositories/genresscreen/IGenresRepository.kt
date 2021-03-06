package ru.androidinvasion.secretbook.repositories.genresscreen

import io.reactivex.Completable
import io.reactivex.Single
import ru.androidinvasion.secretbook.data.api.Genre

/**
* @author Nikita Kulikov <nikita@kulikof.ru>
* @project SecretBookNoSecure
* @date 15.04.18
*/
interface IGenresRepository {
    fun getAllGenres(): Single<List<Genre>>

    fun getMyGenres(): List<Genre>
    fun setMyGenres(list: List<Genre>): Completable
}