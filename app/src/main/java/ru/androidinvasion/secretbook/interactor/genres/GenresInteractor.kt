package ru.androidinvasion.secretbook.interactor.genres

import io.reactivex.Completable
import io.reactivex.Single
import ru.androidinvasion.secretbook.data.genresscreen.Genre
import ru.androidinvasion.secretbook.repositories.genresscreen.IGenresRepository

/**
 * Created by egor on 15.04.18.
 */
class GenresInteractor(private val genresscreenRepository: IGenresRepository) : IGenresInteractor {

    override fun getAllGenres(): Single<List<Genre>> {
        return genresscreenRepository.getAllGenres()
    }

    override fun setMyGenres(list: List<Genre>): Completable {
        return genresscreenRepository.setMyGenres(list)
    }
}