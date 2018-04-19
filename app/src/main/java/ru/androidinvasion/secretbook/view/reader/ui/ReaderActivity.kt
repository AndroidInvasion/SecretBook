package ru.androidinvasion.secretbook.view.reader.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.utils.toast
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
    private lateinit var fragment: ReaderFragment

    companion object {
        const val ACTION_RANDOM = "random"
        const val EXTRA_ACTION = "action"
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
        fragment.setNextListener { presenter.onNextClick() }
        fragment.setBuyListener { presenter.onBuyClick() }
    }

    override fun setBook(book: Book) {
        fragment.setBook(book)
    }

    override fun setProgress(visible: Boolean) {
        fragment.setProgressBarVisible(visible)
    }

    override fun notifyPresenterAboutAction() {
        val action = intent.getStringExtra(EXTRA_ACTION)
        val actionEnum = when (action) {
            ACTION_RANDOM -> ReaderAction.RANDOM
            else -> ReaderAction.RANDOM
        }
        presenter.openReader(actionEnum)
    }

    override fun openUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    override fun showError(resId: Int) {
        toast(resId)
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