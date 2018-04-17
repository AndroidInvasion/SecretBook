package ru.androidinvasion.secretbook.view.genresscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.model.PickerItem
import com.igalata.bubblepicker.rendering.BubblePicker
import kotlinx.android.synthetic.main.activity_genres_screen.*
import kotlinx.android.synthetic.main.view_genre.*
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.data.genresscreen.Genre
import ru.androidinvasion.secretbook.utils.toast
import ru.androidinvasion.secretbook.view.genresscreen.presenter.GenresPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 16.04.18
 */

class GenresActivity : MvpAppCompatActivity(), GenresView, BubblePickerListener {
    @InjectPresenter
    lateinit var presenter: GenresPresenter
    private var pickerView: BubblePicker? = null
    private var isResuming = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres_screen)
        isResuming = true
    }

    override fun setGenresList(genres: List<Genre>) {
        LayoutInflater.from(this).inflate(R.layout.view_genre, selectframe)
        pickerView = picker
        pickerView?.adapter = GenreAdapter(genres, this)
        pickerView?.bubbleSize = 20
        if (isResuming) {
            pickerView?.onResume()
        }
    }

    override fun onResume() {
        super.onResume()
        isResuming = true
        pickerView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        isResuming = false
        pickerView?.onPause()
    }

    override fun onBubbleDeselected(item: PickerItem) {
        val data = item.customData
        if (data != null && data is Genre) {
            presenter.onGenreDeselect(data)
        }
    }

    override fun onBubbleSelected(item: PickerItem) {
        val data = item.customData
        if (data != null && data is Genre) {
            presenter.onGenreSelect(data)
        }
    }

    override fun onError(resId: Int) {
        toast(resId)
    }

    override fun setProgress(visible: Boolean) {
        progressbar.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }
}