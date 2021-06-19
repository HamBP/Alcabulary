package org.algosketch.alcabulary.mvvm.feature.select

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.databinding.ActivitySelectVocabularyBinding

class SelectVocabularyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectVocabularyBinding
    private val viewModel: SelectVocabularyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_vocabulary)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val recyclerView = findViewById<RecyclerView>(R.id.select_vocabulary_recyclerview)
        recyclerView.adapter = SelectVocabularyAdapter(getWordList())
    }

    fun getWordList(): List<SelectVocabularyAdapter.WordVO> {
        val wordList: ArrayList<SelectVocabularyAdapter.WordVO> = ArrayList()
        wordList.add(
            SelectVocabularyAdapter.WordVO("word", "단어", "this is a word")
        )

        return wordList
    }
}