package ru.androidinvasion.secretbook.di.genres

import dagger.Subcomponent
import ru.androidinvasion.secretbook.view.genresscreen.presenter.GenresPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 16.04.18
 */

@Subcomponent(modules = [GenresModule::class])
@GenresScope
interface GenresComponent {
    fun inject(presenter: GenresPresenter)
}