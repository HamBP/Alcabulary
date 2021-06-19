package org.algosketch.alcabulary.mvvm.feature.select

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.databinding.ActivitySelectVocabularyBinding

class SelectVocabularyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectVocabularyBinding
    private val viewModel: SelectVocabularyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_vocabulary)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}