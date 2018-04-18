package ru.androidinvasion.secretbook.view.genresscreen.ui

import android.content.Context
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.PickerItem
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.data.api.Genre
import ru.androidinvasion.secretbook.utils.getColorOld

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBookNoSecure
 * @date 16.04.18
 */

class GenreAdapter(var list: List<Genre>, private var context: Context) : BubblePickerAdapter {
    override val totalCount: Int
        get() = list.size

    override fun getItem(position: Int): PickerItem {
        val item = PickerItem()
        val genre = list[position]
        item.title = genre.name
        item.color = context.getColorOld(R.color.colorPrimary)
        item.textColor = context.getColorOld(android.R.color.white)
        item.isSelected = genre.isSelected
        item.customData = genre
        return item
    }
}