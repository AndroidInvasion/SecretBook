package ru.androidinvasion.secretbook.view.main.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.androidinvasion.secretbook.R
import ru.androidinvasion.secretbook.data.api.Book
import ru.androidinvasion.secretbook.data.api.Genre
import ru.androidinvasion.secretbook.view.main.presenter.MainPresenter
import ru.androidinvasion.secretbook.view.reader.ui.ReaderActivity

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @author Egor Kurakov <egor@live.ru>
 * @project SecretBookNoSecure
 * @date 23.05.18
 */

class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        randombook.setOnClickListener { presenter.onClickRandomBook() }
        /*selected_genres.setOnChipRemovedListener(object : OnChipRemovedListener {
            override fun shouldRemove(position: Int, chip: Chip?, chipView: View?): Boolean {
                return true
            }
            override fun onRemoved(chip: Chip) {
                presenter.onGenreDelete(Genre(name=chip.label))
            }
        })*/
    }

    override fun onStart() {
        super.onStart()
        val viewManager = LinearLayoutManager(this)
        val history: List<Book> = presenter.getHistory()
        val viewAdapter = ReadingHistoryAdapter(history.map { book -> book.name })

        reading_history.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun setSelectedGenres(selectedGenres: HashSet<Genre>) {
        //selected_genres.setItems(selectedGenres.map { genre -> GenreChip(genre.name) })
    }

    override fun onError(error_id: Int) {
        Toast.makeText(this, error_id, Toast.LENGTH_LONG).show()
    }

    override fun openReader() {
        val intent = Intent(this, ReaderActivity::class.java)
        intent.putExtra(ReaderActivity.EXTRA_ACTION, ReaderActivity.ACTION_RANDOM)
        startActivity(intent)
    }
    /*
    private class GenreChip(var name: String) : Chip {
        override fun canDelete(): Boolean {
            return true
        }
        override fun getLabel(): String {
            return name
        }
    }*/
}