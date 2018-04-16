package ru.androidinvasion.secretbook.view.intro.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.view.reader.ui.ReaderActivity

class IntroActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    private val mAdapter = IntroAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splash_screen_view_pagerager.adapter = mAdapter

        indicator.setViewPager(splash_screen_view_pagerager)
        splash_screen_view_pagerager.addOnPageChangeListener(this)
        btn_skip.setOnClickListener {
            when (splash_screen_view_pagerager.currentItem) {
                0 -> openMainActivity()
                else -> splash_screen_view_pagerager.setCurrentItem(
                        splash_screen_view_pagerager.currentItem - 1, true)
            }
        }
        btn_next.setOnClickListener {
            when (splash_screen_view_pagerager.currentItem) {
                mAdapter.count - 1 -> openMainActivity()
                else -> splash_screen_view_pagerager.setCurrentItem(
                        splash_screen_view_pagerager.currentItem + 1, true)
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> btn_skip.setText(R.string.intro_skip)
            else -> btn_skip.setText(R.string.intro_back)
        }
        when (position) {
            mAdapter.count - 1 -> btn_next.setText(R.string.intro_ready)
            else -> btn_next.setText(R.string.intro_next)
        }
    }

    private fun openMainActivity() {
        val intent = Intent(this, ReaderActivity::class.java)
        intent.putExtra(ReaderActivity.EXTRA_ACTION, ReaderActivity.ACTION_RANDOM)
        startActivity(intent)
    }

}
