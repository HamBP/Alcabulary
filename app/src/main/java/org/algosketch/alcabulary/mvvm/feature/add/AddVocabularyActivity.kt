package org.algosketch.alcabulary.mvvm.feature.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.mvvm.model.db.AppDatabase
import org.algosketch.alcabulary.mvvm.model.db.Vocabulary

class AddVocabularyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vocabulary)

        findViewById<Button>(R.id.add_btn_and_main).setOnClickListener {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "vocabulary"
            ).build()
            Thread {
                val dao = db.VocabularyDao()
                dao.insertVocabulary(Vocabulary(1, "resume", "이력서", "I submitted resume."))
                Log.d("데이터 삽입 : ", "결과 : " + dao.getAll()[0].exampleSentence)
            }.start()
            finish()
        }
    }
}