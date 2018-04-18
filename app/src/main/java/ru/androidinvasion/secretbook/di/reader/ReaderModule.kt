package ru.androidinvasion.secretbook.di.reader

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.androidinvasion.secretbook.interactor.reader.IReaderInteractor
import ru.androidinvasion.secretbook.interactor.reader.ReaderInteractor
import ru.androidinvasion.secretbook.repositories.genresscreen.GenresRepository
import ru.androidinvasion.secretbook.repositories.genresscreen.IGenresRepository
import ru.androidinvasion.secretbook.repositories.reader.IReaderRepository
import ru.androidinvasion.secretbook.repositories.reader.ReaderRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

@Module
@ReaderScope
class ReaderModule {

    @Provides
    @ReaderScope
    fun provideReaderRepo(retrofit: Retrofit): IReaderRepository {
        return ReaderRepository(retrofit)
    }

    @Provides
    @ReaderScope
    fun provideGenresRepo(sharedPreferences: SharedPreferences, retrofit: Retrofit): IGenresRepository {
        return GenresRepository(sharedPreferences, retrofit)
    }

    @Provides
    @ReaderScope
    fun provideInteractor(readerRepo: IReaderRepository, genresRepo: IGenresRepository): IReaderInteractor {
        return ReaderInteractor(readerRepo, genresRepo)
    }
}