package org.algosketch.alcabulary.mvvm.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.algosketch.alcabulary.mvvm.feature.add.AddVocabularyActivity
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.mvvm.feature.example.StudyExampleActivity
import org.algosketch.alcabulary.mvvm.feature.select.SelectVocabularyActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.main_btn_add).setOnClickListener {
            val intent = Intent(this, AddVocabularyActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.main_btn_study).setOnClickListener {
            val intent = Intent(this, StudyExampleActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.main_btn_selection).setOnClickListener {
            val intent = Intent(this, SelectVocabularyActivity::class.java)
            startActivity(intent)
        }
    }
}