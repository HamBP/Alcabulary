package org.algosketch.alcabulary.mvvm.feature.select

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import org.algosketch.alcabulary.mvvm.global.MyApplication
import org.algosketch.alcabulary.mvvm.model.db.AppDatabase
import org.algosketch.alcabulary.mvvm.model.db.MIGRATION_1_2
import org.algosketch.alcabulary.mvvm.model.db.VocabularyDao
import java.util.*

class SelectVocabularyViewModel : ViewModel() {
    val wordList = MutableLiveData<List<SelectVocabularyAdapter.WordVO>>()

    fun getWordList() {
        Thread {
            val db = Room.databaseBuilder(
                MyApplication.ApplicationContext(),
                AppDatabase::class.java,
                "vocabulary"
            ).addMigrations(MIGRATION_1_2).build()

            val words = db.VocabularyDao().getAll()

            var inputWords: List<SelectVocabularyAdapter.WordVO> = words.map {
                Log.d("word", it.word)
                SelectVocabularyAdapter.WordVO(it.word, it.meaning, it.exampleSentence, true)
            }
            wordList.postValue(inputWords)
        }.start()
    }
}