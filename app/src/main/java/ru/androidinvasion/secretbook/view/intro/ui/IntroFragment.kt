package ru.androidinvasion.secretbook.view.intro.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_intro.*
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.utils.Constants

class IntroFragment : Fragment() {
    private var data: IntroEnum? = null

    companion object {
        fun newInstance(data: IntroEnum): IntroFragment {
            val fragment = IntroFragment()

            val args = Bundle()
            args.putSerializable(Constants.EXTRA_INTROENUM, data)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = arguments?.getSerializable(Constants.EXTRA_INTROENUM) as IntroEnum?
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intro = data ?: return

        image.setImageResource(intro.imageRes)
        title.setText(intro.title)
        description.setText(intro.description)
    }
}