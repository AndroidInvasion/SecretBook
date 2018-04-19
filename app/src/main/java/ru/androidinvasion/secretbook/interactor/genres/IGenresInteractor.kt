package ru.androidinvasion.secretbook.interactor.genres

import io.reactivex.Completable
import io.reactivex.Single
import ru.androidinvasion.secretbook.data.api.Genre

/**
* @author Nikita Kulikov <nikita@kulikof.ru>
* @project SecretBookNoSecure
* @date 15.04.18
*/
interface IGenresInteractor {
    fun getAllGenres(): Single<List<Genre>>

    fun setMyGenres(list: List<Genre>): Completable
}