package org.algosketch.alcabulary.mvvm.feature.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.databinding.ActivityAddVocabularyBinding

class AddVocabularyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddVocabularyBinding
    private val viewModel: AddVocabularyViewModel by viewModels()

    private var inputWord: EditText? = null
    private var inputMeaning: EditText? = null
    private var inputSentence: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_vocabulary)

        inputWord = findViewById(R.id.add_edit_vocabulary)
        inputMeaning = findViewById(R.id.add_edit_meaning)
        inputSentence = findViewById(R.id.add_edit_example_sentence)

        // 완료 후 메인 버튼
        findViewById<Button>(R.id.add_btn_and_main).setOnClickListener {
            if(isCorrect()) {
                request()
                finish()
            }
            else Toast.makeText(this, "단어 혹은 뜻을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show()
        }

        // 완료 후 하나 더 추가 버튼
        findViewById<Button>(R.id.add_btn_and_add).setOnClickListener {
            if(isCorrect()) {
                request()
                finish()
            }
            else Toast.makeText(this, "단어 혹은 뜻을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    // 코드 중복 무엇...?
    private fun isCorrect(): Boolean {
        val word = inputWord?.text.toString()
        val meaning = inputMeaning?.text.toString()
        return word.isNotEmpty() && meaning.isNotEmpty()
    }

    private fun request() {
        val word = inputWord?.text.toString()
        val meaning = inputMeaning?.text.toString()
        val sentence = inputSentence?.text.toString()
        viewModel.postWord(word, meaning, sentence)
    }
}