package ru.androidinvasion.secretbook.repositories.readinghistory

import android.content.SharedPreferences
import ru.androidinvasion.secretbook.data.api.Book

/**
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

class ReadingHistoryRepository(private val sharedPreferences: SharedPreferences) : IReadingHistoryRepository {
    companion object {
        const val INDEX_KEY = "reading_history_index"
        const val KEY_PREFIX = "reading_history_"
    }

    override fun addReadedBook(book: Book) {
        val index = sharedPreferences.getInt(INDEX_KEY, 0)
        sharedPreferences.edit().putString(KEY_PREFIX + index.toString(), book.name)
                .putInt(INDEX_KEY, index + 1).apply()
    }

    override fun getReadingHistory(): List<Book> {
        val history = ArrayList<Book>()
        val lastIndex = sharedPreferences.getInt(INDEX_KEY, -1)
        if (lastIndex == -1) {
            return history
        }

        for (i in 0..lastIndex) {
            val book = Book()
            book.name = sharedPreferences.getString(KEY_PREFIX + i.toString(), "")
            history.add(book)
        }

        return history
    }
}