package ru.androidinvasion.secretbook.data.api

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import ru.androidinvasion.secretbook.data.genresscreen.Genre
import java.util.*

/**
 * Created by egor on 16.04.18.
 */
interface Api {
    @GET("  tags")
    fun getTags(): Single<List<Genre>>
}