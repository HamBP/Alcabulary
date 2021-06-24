package org.algosketch.alcabulary.mvvm.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.algosketch.alcabulary.mvvm.feature.add.AddVocabularyActivity
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.databinding.ActivityMainBinding
import org.algosketch.alcabulary.mvvm.feature.example.StudyExampleActivity
import org.algosketch.alcabulary.mvvm.feature.select.SelectVocabularyActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.shouldStartActivity.observe(this, Observer { startActivity(it) })
    }
}