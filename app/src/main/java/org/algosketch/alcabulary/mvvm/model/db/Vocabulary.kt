package org.algosketch.alcabulary.mvvm.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vocabulary (
    @PrimaryKey(autoGenerate = true) val vid: Int,
    val vocabulary: String,
    val meaning: String,
    @ColumnInfo(name = "example_sentence") val exampleSentence: String?
    )