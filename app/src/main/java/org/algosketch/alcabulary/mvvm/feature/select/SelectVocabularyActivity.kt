package org.algosketch.alcabulary.mvvm.feature.select

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.databinding.ActivitySelectVocabularyBinding

class SelectVocabularyActivity : AppCompatActivity() {
    private val TAG = "단어 선택 화면"
    private lateinit var binding: ActivitySelectVocabularyBinding
    private val viewModel: SelectVocabularyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_vocabulary)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.selectVocabularyRecyclerview.adapter = SelectVocabularyAdapter(listOf(SelectVocabularyAdapter.WordVO("wor", "meaning", "example")))

        // 이게 좋은 코드인지 모르겠음.
        viewModel.wordList.observe(this, Observer {
            binding.selectVocabularyRecyclerview.adapter = SelectVocabularyAdapter(it)
        })
        viewModel.getWordList()
    }
}