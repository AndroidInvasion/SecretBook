package ru.androidinvasion.secretbook.view.splashscreen.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SplashScreenPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val screenLists = Array(NUM_ITEMS, { i -> SplashScreenListFragment.newInstance(i) })

    companion object {
        const val NUM_ITEMS = 3
    }

    override fun getItem(position: Int): Fragment {
        return screenLists[position]
    }

    override fun getCount(): Int {
        return NUM_ITEMS
    }
}