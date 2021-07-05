package org.algosketch.alcabulary.mvvm.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vocabulary (
    @PrimaryKey(autoGenerate = true) val vid: Int = 0,
    @ColumnInfo(name = "vocabulary")val word: String,
    val meaning: String,
    @ColumnInfo(name = "example_sentence") val exampleSentence: String?,
    @ColumnInfo(name = "is_checked") val isChecked: Boolean = true
    )