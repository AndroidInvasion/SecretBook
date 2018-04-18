package ru.androidinvasion.secretbook.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
* @author Nikita Kulikov <nikita@kulikof.ru>
* @project SecretBookNoSecure
* @date 16.04.18
*/
interface Api {
    @GET("tags")
    fun getTags(): Single<List<Genre>>

    @GET("books")
    fun getRandomBook(@Query("count") count: Int,
                      @Query("tags") tags: IntArray): Single<List<Book>>
}