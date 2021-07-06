package org.algosketch.alcabulary.mvvm.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Dao
interface VocabularyDao {
    @Query("select * from vocabulary")
    fun getAll(): List<Vocabulary>

    @Insert
    fun insertWord(vararg vocabulary: Vocabulary)

    @Delete
    fun deleteVocabulary(vocabulary: Vocabulary)
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE vocabulary ADD COLUMN is_checked INTEGER")
    }
}