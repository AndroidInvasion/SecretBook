package ru.androidinvasion.secretbook.view.genresscreen.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.BubbleGradient
import com.igalata.bubblepicker.model.PickerItem
import kotlinx.android.synthetic.main.activity_genres_screen.*
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.utils.toast

/**
 * Created by egor on 15.04.18.
 */

class GenresscreenActivity : Activity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres_screen)

        val genres = resources.getStringArray(R.array.genres)
        val colors = resources.obtainTypedArray(R.array.colors)
//    val images = resources.obtainTypedArray(R.array.images)

        picker.adapter = object: BubblePickerAdapter {
            override val totalCount = genres.size

            override fun getItem(position: Int): PickerItem {
                return PickerItem().apply {
                    title = genres[position]
                    gradient = BubbleGradient(colors.getColor((position * 2) % 8, 0),
                            colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL)
                    //TODO:
//                typeface = mediumTypeface
                    textColor = ContextCompat.getColor(this@GenresscreenActivity, android.R.color.white)
//                    backgroundImage = ContextCompat.getDrawable(this@GenresscreenActivity, images.getResourceId(position, 0))
                }
            }

        }
        picker.listener = object : BubblePickerListener {
            override fun onBubbleSelected(item: PickerItem) {
                //TODO:
                toast("${item.title} selected")
            }

            override fun onBubbleDeselected(item: PickerItem) {
                //Nothing
                picker.selectedItems.forEach { toast(it?.title!!) }
            }
        }
    }



    override fun onResume() {
        super.onResume()
        picker.onResume()
    }

    override fun onPause() {
        super.onPause()
        picker.onPause()
    }



}