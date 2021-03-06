package org.algosketch.alcabulary.mvvm.model.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Vocabulary::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun VocabularyDao(): VocabularyDao
}