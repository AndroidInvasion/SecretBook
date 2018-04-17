package ru.androidinvasion.secretbook.di.genres

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.androidinvasion.secretbook.interactor.genres.GenresInteractor
import ru.androidinvasion.secretbook.interactor.genres.IGenresInteractor
import ru.androidinvasion.secretbook.repositories.genresscreen.GenresRepository
import ru.androidinvasion.secretbook.repositories.genresscreen.IGenresRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 16.04.18
 */

@Module
@GenresScope
class GenresModule {

    @Provides
    @GenresScope
    fun provideRepo(sharedPreferences: SharedPreferences, retrofit: Retrofit): IGenresRepository {
        return GenresRepository(sharedPreferences, retrofit)
    }

    @Provides
    @GenresScope
    fun provideInteractor(repo: IGenresRepository): IGenresInteractor {
        return GenresInteractor(repo)
    }
}