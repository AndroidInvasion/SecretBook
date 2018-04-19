package ru.androidinvasion.secretbook.interactor.reader

import io.reactivex.Single
import ru.androidinvasion.secretbook.data.api.Book
import ru.androidinvasion.secretbook.repositories.genresscreen.IGenresRepository
import ru.androidinvasion.secretbook.repositories.reader.IReaderRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

class ReaderInteractor(private val repository: IReaderRepository, private val genresRepo: IGenresRepository) : IReaderInteractor {
    override fun getRandomBook(): Single<Book> {
        return repository
                .getRandomBooks(genresRepo.getMyGenres())
                .map { it.first() }
    }

}