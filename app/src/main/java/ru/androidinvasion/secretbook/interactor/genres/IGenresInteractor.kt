package ru.androidinvasion.secretbook.interactor.genres

import io.reactivex.Completable
import io.reactivex.Single
import ru.androidinvasion.secretbook.data.genresscreen.Genre

/**
 * Created by egor on 15.04.18.
 */
interface IGenresInteractor {
    fun getAllGenres(): Single<List<Genre>>

    fun setMyGenres(list: List<Genre>): Completable
}