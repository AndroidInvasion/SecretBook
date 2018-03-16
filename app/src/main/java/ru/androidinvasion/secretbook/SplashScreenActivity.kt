package ru.androidinvasion.secretbook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import ru.androidinvasion.secretbook.splashscreen.SplashScreenPagerAdapter

class SplashScreenActivity : AppCompatActivity() {
    private val mAdapter = SplashScreenPagerAdapter(supportFragmentManager)
    private var mPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mPager = findViewById(R.id.splash_screen_view_pagerager)
        mPager!!.adapter = mAdapter
    }
}
