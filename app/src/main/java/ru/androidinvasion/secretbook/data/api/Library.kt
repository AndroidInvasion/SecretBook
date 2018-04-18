package ru.androidinvasion.secretbook.data.api

import com.google.gson.annotations.SerializedName

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

data class Library(var id: Int,
                   var name: String,
                   var description: String,
                   @SerializedName("library_url")
                   var libraryUrl: String,
                   @SerializedName("image_url")
                   var imageUrl: String) {
    constructor() : this(0, "", "", "", "")
}