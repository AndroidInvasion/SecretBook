package ru.androidinvasion.secretbook.repositories.genresscreen

import android.content.SharedPreferences
import ru.androidinvasion.secretbook.data.genresscreen.Genre

/**
 * Created by egor on 15.04.18.
 */
class GenresscreenRepository(private val sharedPreferences: SharedPreferences) : IGenresscreenRepository {
    override fun getMyGenres(): List<Genre> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllGenres(): List<Genre> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}