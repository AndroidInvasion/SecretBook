package ru.androidinvasion.secretbook.di.main

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.androidinvasion.secretbook.interactor.main.IMainInteractor
import ru.androidinvasion.secretbook.interactor.main.MainInteractor
import ru.androidinvasion.secretbook.repositories.genresscreen.GenresRepository
import ru.androidinvasion.secretbook.repositories.genresscreen.IGenresRepository
import ru.androidinvasion.secretbook.repositories.readinghistory.IReadingHistoryRepository
import ru.androidinvasion.secretbook.repositories.readinghistory.ReadingHistoryRepository

/**
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

@Module
@MainScope
class MainModule {

    @Provides
    @MainScope
    fun provideReadingHistoryRepo(sharedPreferences: SharedPreferences): IReadingHistoryRepository {
        return ReadingHistoryRepository(sharedPreferences)
    }

    @Provides
    @MainScope
    fun provideGenresRepo(sharedPreferences: SharedPreferences, retrofit: Retrofit): IGenresRepository {
        return GenresRepository(sharedPreferences, retrofit)
    }

    @Provides
    @MainScope
    fun provideInteractor(readingHistoryRepo: IReadingHistoryRepository, genresRepo: IGenresRepository): IMainInteractor {
        return MainInteractor(readingHistoryRepo, genresRepo)
    }
}