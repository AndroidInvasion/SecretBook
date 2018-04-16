package ru.androidinvasion.secretbook.view.reader.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.view.reader.presenter.ReaderPresenter
import ru.lionzxy.yetanotherreaderlibrary.ReaderFragment
import ru.lionzxy.yetanotherreaderlibrary.data.Book

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 14.04.18
 */

class ReaderActivity : MvpAppCompatActivity(), IReaderView {

    @InjectPresenter
    lateinit var presenter: ReaderPresenter
    lateinit var fragment: ReaderFragment

    companion object {
        val ACTION_RANDOM = "random"
        val EXTRA_ACTION = "action"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)

        var tmpFragment = supportFragmentManager.findFragmentByTag(ReaderFragment.TAG) as ReaderFragment?
        if (tmpFragment == null) {
            tmpFragment = ReaderFragment()
            tmpFragment.retainInstance = true
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, tmpFragment)
                    .commit()
        }
        fragment = tmpFragment

    }

    override fun setBook(book: Book) {
        fragment.setBook(book)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}