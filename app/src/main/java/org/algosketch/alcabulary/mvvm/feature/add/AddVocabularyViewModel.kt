package org.algosketch.alcabulary.mvvm.feature.add

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.room.Room
import org.algosketch.alcabulary.mvvm.global.MyApplication
import org.algosketch.alcabulary.mvvm.model.db.AppDatabase
import org.algosketch.alcabulary.mvvm.model.db.MIGRATION_1_2
import org.algosketch.alcabulary.mvvm.model.db.Vocabulary
import java.util.*

class AddVocabularyViewModel : ViewModel() {
    val inputWord = ObservableField("")
    val inputMeaning = ObservableField("")
    val inputSentence = ObservableField("")
    val shouldFinish = MutableLiveData<Void?>()

    fun postWord(word: String, meaning: String, exampleSentence: String?) {
        val insertData = Vocabulary(word = word, meaning = meaning, exampleSentence = exampleSentence)
        Log.d("데이터 삽입 요청 : ", "단어 : " + word + "; " + meaning + "; " + exampleSentence)
        Thread {
            val db = Room.databaseBuilder(
                MyApplication.ApplicationContext(),
                AppDatabase::class.java,
                "vocabulary"
            ).addMigrations(MIGRATION_1_2)
                .build()

            val dao = db.VocabularyDao()
            dao.insertWord(insertData)
            val data = dao.getAll()
            Log.d("데이터 삽입 요청 : ", "결과 : " + data[data.size - 1].vid + "; " + data[data.size - 1].word)
        }.start()
    }

    private fun isCorrect(): Boolean {
        return inputWord.toString().isNotEmpty() && inputMeaning.toString().isNotEmpty()
    }

    private fun request() {
        postWord(inputWord.toString(), inputMeaning.toString(), inputSentence.toString())
    }

    fun requestAndClose() {
        if(isCorrect()) {
            request()
            shouldFinish.postValue(null)
        }
        else Toast.makeText(MyApplication.ApplicationContext(), "단어 혹은 뜻을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show()
    }

    fun requestAndNext() {
        if(isCorrect()) {
            request()
            shouldFinish.postValue(null)
        }
        else Toast.makeText(MyApplication.ApplicationContext(), "단어 혹은 뜻을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show()
    }
}