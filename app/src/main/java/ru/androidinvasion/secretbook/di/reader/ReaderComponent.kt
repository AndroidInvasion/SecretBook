package ru.androidinvasion.secretbook.di.reader

import dagger.Subcomponent
import ru.androidinvasion.secretbook.view.reader.presenter.ReaderPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

@Subcomponent(modules = [ReaderModule::class])
@ReaderScope
interface ReaderComponent {
    fun inject(presenter: ReaderPresenter)
}