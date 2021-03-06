package ru.androidinvasion.secretbook.view.main.ui

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.view.main.presenter.MainPresenter
import ru.androidinvasion.secretbook.view.reader.ui.ReaderActivity

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 18.04.18
 */

class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randombook.setOnClickListener { presenter.onClickRandomBook() }
    }

    override fun openRandomBook() {
        val intent = Intent(this, ReaderActivity::class.java)
        intent.putExtra(ReaderActivity.EXTRA_ACTION, ReaderActivity.ACTION_RANDOM)
        startActivity(intent)
    }
}