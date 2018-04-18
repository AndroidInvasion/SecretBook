package ru.androidinvasion.secretbook.data.api

import com.google.gson.annotations.SerializedName

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

data class Store(var id: Int,
                 var name: String,
                 var description: String,
                 @SerializedName("store_url")
                 var storeurl: String,
                 @SerializedName("image_url")
                 var imageurl: String) {

    constructor() : this(0, "", "", "", "")
}