package ru.androidinvasion.secretbook.data.genresscreen

import com.google.gson.annotations.SerializedName

/**
 * Created by egor on 15.04.18.
 */
class Genre(@SerializedName("id")
            var id: Int = 0,
            @SerializedName("name")
            var name: String,
            var isSelected: Boolean = false) {

    constructor() : this(0, "") {}

    constructor(line: String) : this() {
        val tmp = line.split(":")
        id = Integer.valueOf(tmp[0])
        name = tmp[1]
    }

    override fun toString(): String {
        return "$id:$name"
    }
}