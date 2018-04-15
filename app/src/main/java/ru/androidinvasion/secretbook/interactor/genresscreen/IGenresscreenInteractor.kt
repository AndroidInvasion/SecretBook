package ru.androidinvasion.secretbook.interactor.genresscreen

import ru.androidinvasion.secretbook.data.genresscreen.Genre

/**
 * Created by egor on 15.04.18.
 */
interface IGenresscreenInteractor {
    fun getAllGenres(): List<Genre>

    fun getMyGenres(): List<Genre>
}