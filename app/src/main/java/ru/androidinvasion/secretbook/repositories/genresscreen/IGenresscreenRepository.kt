package ru.androidinvasion.secretbook.repositories.genresscreen

import ru.androidinvasion.secretbook.data.genresscreen.Genre

/**
 * Created by egor on 15.04.18.
 */
interface IGenresscreenRepository {
    fun getAllGenres(): List<Genre>

    fun getMyGenres(): List<Genre>
}