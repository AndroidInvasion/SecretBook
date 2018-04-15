package ru.androidinvasion.secretbook.interactor.genresscreen

import ru.androidinvasion.secretbook.data.genresscreen.Genre
import ru.androidinvasion.secretbook.repositories.genresscreen.IGenresscreenRepository

/**
 * Created by egor on 15.04.18.
 */
class GenresscreenInteractor(private val genresscreenRepository: IGenresscreenRepository) : IGenresscreenInteractor {
    override fun getAllGenres(): List<Genre> {
        return genresscreenRepository.getAllGenres()
    }

    override fun getMyGenres(): List<Genre> {
        return genresscreenRepository.getMyGenres()
    }

}