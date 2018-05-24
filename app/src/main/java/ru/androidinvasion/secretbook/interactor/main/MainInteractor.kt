package ru.androidinvasion.secretbook.interactor.main

import io.reactivex.Single
import ru.androidinvasion.secretbook.data.api.Book
import ru.androidinvasion.secretbook.data.api.Genre
import ru.androidinvasion.secretbook.repositories.genresscreen.IGenresRepository
import ru.androidinvasion.secretbook.repositories.readinghistory.IReadingHistoryRepository

/**
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

class MainInteractor(private val readingHistoryRepository: IReadingHistoryRepository,
                     private val genresRepo: IGenresRepository) : IMainInteractor {
    override fun addReadedBook(book: Book) {
        readingHistoryRepository.addReadedBook(book)
    }

    override fun getReadingHistory(): List<Book> {
        return readingHistoryRepository.getReadingHistory()
    }

    override fun setMyGenres(genres: List<Genre>) {
        genresRepo.setMyGenres(genres)
    }

    override fun getAllGenres(): Single<List<Genre>> {
        return genresRepo.getAllGenres()
    }

}