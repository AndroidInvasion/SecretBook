package ru.androidinvasion.secretbook.data.api

import com.google.gson.annotations.SerializedName
import ru.lionzxy.yetanotherreaderlibrary.data.Book

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

data class Book(var id: Int,
                var fragment: String,
                @SerializedName("fragment_autor")
                var fragmentAuthor: Author,
                var name: String,
                var description: String,
                @SerializedName("autor")
                var author: Array<Author>,
                var publisher: Author,
                var pages: Int,
                @SerializedName("image_url")
                var imageUrl: String,
                var stores: Array<Store>,
                var tags: Array<Genre>,
                var libraries: Array<Library>,
                var year: Int) {
    constructor() : this(0, "", Author(),
            "", "", emptyArray<Author>(),
            Author(), 0, "",
            emptyArray<Store>(), emptyArray<Genre>(), emptyArray<Library>(), 0)

    fun toReaderBook(): Book =
            ru.lionzxy.yetanotherreaderlibrary.data.Book(name,
                    author.map { it.name }.joinToString(", "),
                    fragment, imageUrl, description)
}