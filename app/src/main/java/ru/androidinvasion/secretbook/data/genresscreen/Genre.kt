package ru.androidinvasion.secretbook.data.genresscreen

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by egor on 15.04.18.
 */
class Genre {
    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("name")
    @Expose
    lateinit var name: String

}