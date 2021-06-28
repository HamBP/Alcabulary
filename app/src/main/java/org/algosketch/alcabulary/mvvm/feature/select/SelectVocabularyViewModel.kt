package org.algosketch.alcabulary.mvvm.feature.select

import androidx.lifecycle.ViewModel
import androidx.room.Room
import org.algosketch.alcabulary.mvvm.global.MyApplication
import org.algosketch.alcabulary.mvvm.model.db.AppDatabase
import org.algosketch.alcabulary.mvvm.model.db.VocabularyDao

class SelectVocabularyViewModel : ViewModel() {
    init {
        val db = Room.databaseBuilder(
            MyApplication.ApplicationContext(),
            AppDatabase::class.java,
            "vocabulary"
        ).build()

        Thread {
            val words = db.VocabularyDao().getAll()
            // TODO : 아답터에 데이터 삽입
        }
    }
}