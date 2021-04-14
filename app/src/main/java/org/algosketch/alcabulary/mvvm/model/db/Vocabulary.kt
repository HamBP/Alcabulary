package org.algosketch.alcabulary.mvvm.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vocabulary (
    @PrimaryKey val vid: Int,
    @ColumnInfo(name = "vocabulary") val vocabulary: String,
    @ColumnInfo(name = "meaning") val meaning: String,
    @ColumnInfo(name = "example_sentence") val exampleSentence: String?
    )