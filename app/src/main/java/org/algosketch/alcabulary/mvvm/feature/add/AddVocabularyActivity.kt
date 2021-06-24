package org.algosketch.alcabulary.mvvm.feature.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.databinding.ActivityAddVocabularyBinding

class AddVocabularyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddVocabularyBinding
    private val viewModel: AddVocabularyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_vocabulary)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.shouldFinish.observe(this, Observer { finish() })
    }
}