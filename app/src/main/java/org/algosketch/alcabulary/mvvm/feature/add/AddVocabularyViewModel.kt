package org.algosketch.alcabulary.mvvm.feature.add

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.room.Room
import org.algosketch.alcabulary.mvvm.global.MyApplication
import org.algosketch.alcabulary.mvvm.model.db.AppDatabase
import org.algosketch.alcabulary.mvvm.model.db.Vocabulary

class AddVocabularyViewModel : ViewModel() {
    fun postWord(word: String, meaning: String, exampleSentence: String?) {
        val insertData = Vocabulary(word = word, meaning = meaning, exampleSentence = exampleSentence)
        Log.d("데이터 삽입 요청 : ", "단어 : " + word + "; " + meaning + "; " + exampleSentence)
        Thread {
            val db = Room.databaseBuilder(
                MyApplication.ApplicationContext(),
                AppDatabase::class.java,
                "vocabulary"
            ).build()

            val dao = db.VocabularyDao()
            dao.insertWord(insertData)
            val data = dao.getAll()
            Log.d("데이터 삽입 요청 : ", "결과 : " + data[data.size - 1].vid + "; " + data[data.size - 1].word)
        }.start()
    }
}