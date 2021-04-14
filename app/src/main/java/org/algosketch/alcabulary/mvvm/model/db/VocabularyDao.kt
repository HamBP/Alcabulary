package org.algosketch.alcabulary.mvvm.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VocabularyDao {
    @Query("select * from vocabulary")
    fun getAll(): List<Vocabulary>

    @Insert
    fun insertVocabulary(vararg vocabulary: Vocabulary)

    @Delete
    fun deleteVocabulary(vocabulary: Vocabulary)
}