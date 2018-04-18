package ru.androidinvasion.secretbook.data.api

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

data class Author(var id: Int,
                  var name: String,
                  var description: String,
                  var links: Array<String>) {
    companion object {
        const val MAGIC_NUMBER = 31
    }

    constructor() : this(0, "", "", emptyArray())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = MAGIC_NUMBER * result + name.hashCode()
        result = MAGIC_NUMBER * result + description.hashCode()
        return result
    }

}