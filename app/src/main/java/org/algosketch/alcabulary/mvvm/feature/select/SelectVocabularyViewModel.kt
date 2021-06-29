package org.algosketch.alcabulary.mvvm.feature.select

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import org.algosketch.alcabulary.mvvm.global.MyApplication
import org.algosketch.alcabulary.mvvm.model.db.AppDatabase
import org.algosketch.alcabulary.mvvm.model.db.VocabularyDao
import java.util.*

class SelectVocabularyViewModel : ViewModel() {
    var wordList: MutableLiveData<List<SelectVocabularyAdapter.WordVO>>? = null

    fun getWordList() {
        val db = Room.databaseBuilder(
            MyApplication.ApplicationContext(),
            AppDatabase::class.java,
            "vocabulary"
        ).build()

        // TODO : 리스트 출력 안 됨.
        Thread {
            val words = db.VocabularyDao().getAll()

            var inputWords: List<SelectVocabularyAdapter.WordVO> = words.map {
                Log.d("word", it.word)
                SelectVocabularyAdapter.WordVO(it.word, it.meaning, it.exampleSentence)
            }
            Log.d("123", "123")
            inputWords = listOf(SelectVocabularyAdapter.WordVO("word", "meaning", "example"))
            wordList?.postValue(inputWords)
        }.start()
    }
}