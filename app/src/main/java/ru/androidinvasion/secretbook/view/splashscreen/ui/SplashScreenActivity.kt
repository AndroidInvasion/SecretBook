package ru.androidinvasion.secretbook.view.splashscreen.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.data.splashscreen.UpdateModel
import ru.androidinvasion.secretbook.view.splashscreen.presenter.SplashscreenPresenter

class SplashScreenActivity : MvpAppCompatActivity(), ISplashscreenView {
    override fun setUpdates(updates: List<UpdateModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @InjectPresenter
    lateinit var presenter: SplashscreenPresenter
    private val mAdapter = SplashScreenPagerAdapter(supportFragmentManager)
    private var mPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mPager = findViewById(R.id.splash_screen_view_pagerager)
        mPager?.adapter = mAdapter
        presenter.loadUpdates()
    }
}
