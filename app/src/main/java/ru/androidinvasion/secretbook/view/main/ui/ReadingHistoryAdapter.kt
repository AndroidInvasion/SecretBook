package ru.androidinvasion.secretbook.view.main.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.androidinvasion.secretbook.R

class ReadingHistoryAdapter(private val history: List<String>) :
        RecyclerView.Adapter<ReadingHistoryAdapter.HistoryItemViewHolder>() {
    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        holder.textView.text = history[position]
    }

    override fun getItemCount(): Int {
        return history.size
    }

    class HistoryItemViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        val textView = rootView.findViewById<TextView>(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.reading_history_item, parent, false)
        return HistoryItemViewHolder(view)
    }
}
