package org.algosketch.alcabulary.mvvm.feature.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.databinding.ActivityStudyExampleBinding

class StudyExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudyExampleBinding
    private val viewModel: StudyExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_study_example)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.setVocabulary()
    }
}