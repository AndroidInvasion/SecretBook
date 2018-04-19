package ru.androidinvasion.secretbook.data.api

import com.google.gson.annotations.SerializedName

/**
* @author Nikita Kulikov <nikita@kulikof.ru>
* @project SecretBookNoSecure
* @date 15.04.18
*/

class Genre(@SerializedName("id")
            var id: Int = 0,
            @SerializedName("name")
            var name: String,
            var isSelected: Boolean = false) {

    constructor() : this(0, "")

    constructor(line: String) : this() {
        val tmp = line.split(":")
        id = Integer.valueOf(tmp[0])
        name = tmp[1]
    }

    override fun hashCode(): Int {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Genre) {
            return false
        }
        return other.id == id
    }

    override fun toString(): String {
        return "$id:$name"
    }
}