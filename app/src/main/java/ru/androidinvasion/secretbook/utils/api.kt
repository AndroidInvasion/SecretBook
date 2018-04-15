package ru.androidinvasion.secretbook.utils

import retrofit2.Call
import retrofit2.http.GET
import ru.androidinvasion.secretbook.data.genresscreen.Genre

/**
 * Created by egor on 16.04.18.
 */
interface Api {
    @GET("/tags")
    fun getData(): Call<List<Genre>>
}