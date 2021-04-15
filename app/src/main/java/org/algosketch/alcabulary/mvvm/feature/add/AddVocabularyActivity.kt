package org.algosketch.alcabulary.mvvm.feature.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import org.algosketch.alcabulary.R

class AddVocabularyActivity : AppCompatActivity() {
    private val viewModel: AddVocabularyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vocabulary)

        findViewById<Button>(R.id.add_btn_and_main).setOnClickListener {
            val word = findViewById<EditText>(R.id.add_edit_vocabulary).text.toString()
            val meaning = findViewById<EditText>(R.id.add_edit_meaning).text.toString()
            val sentence = findViewById<EditText>(R.id.add_edit_example_sentence).text.toString()
            viewModel.postWord(word, meaning, sentence)
            finish()
        }
    }
}