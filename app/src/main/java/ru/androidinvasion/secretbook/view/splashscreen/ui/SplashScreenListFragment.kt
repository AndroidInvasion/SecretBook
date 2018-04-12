package ru.androidinvasion.secretbook.view.splashscreen.ui

import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pager_list.*
import ru.androidinvasion.secretbook.R

class SplashScreenListFragment : ListFragment() {
    private var position: Int? = null

    companion object {
        fun newInstance(position: Int): SplashScreenListFragment {
            val splashScreenListFragment = SplashScreenListFragment()

            val args = Bundle()
            args.putInt("position", position)
            splashScreenListFragment.arguments = args
            return splashScreenListFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = arguments?.getInt("position")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pager_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = (position ?: -1).toString()
    }
}