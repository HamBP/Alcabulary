package org.algosketch.alcabulary.mvvm.feature.select

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.algosketch.alcabulary.R

class SelectVocabularyAdapter(private val wordList: List<WordVO>) : RecyclerView.Adapter<SelectVocabularyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_select_vocabulary, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.word.text = wordList[position].word
        holder.mean.text = wordList[position].mean
        holder.sentence.text = wordList[position].sentence
    }

    override fun getItemCount(): Int = wordList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val word: TextView = view.findViewById(R.id.word)
        val mean: TextView = view.findViewById(R.id.mean)
        val sentence: TextView = view.findViewById(R.id.sentence)
    }

    data class WordVO(val word: String, val mean: String, val sentence: String?)
}