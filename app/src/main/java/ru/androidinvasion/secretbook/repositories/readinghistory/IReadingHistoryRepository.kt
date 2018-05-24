package ru.androidinvasion.secretbook.repositories.readinghistory

import ru.androidinvasion.secretbook.data.api.Book

/**
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

interface IReadingHistoryRepository {
    fun addReadedBook(book: Book)
    fun getReadingHistory(): List<Book>
}