package org.algosketch.alcabulary.mvvm.feature.main

import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.algosketch.alcabulary.R
import org.algosketch.alcabulary.mvvm.feature.add.AddVocabularyActivity
import org.algosketch.alcabulary.mvvm.feature.example.StudyExampleActivity
import org.algosketch.alcabulary.mvvm.feature.select.SelectVocabularyActivity
import org.algosketch.alcabulary.mvvm.global.MyApplication

class MainViewModel : ViewModel() {
    val shouldStartActivity = MutableLiveData<Intent?>()

    fun btnAddVocabulary() {
        val intent = Intent(MyApplication.ApplicationContext(), AddVocabularyActivity::class.java)
        shouldStartActivity.postValue(intent)
    }
    fun btnStudyVocabulary() {
        val intent = Intent(MyApplication.ApplicationContext(), StudyExampleActivity::class.java)
        shouldStartActivity.postValue(intent)
    }
    fun btnSelectVocabulary() {
        val intent = Intent(MyApplication.ApplicationContext(), SelectVocabularyActivity::class.java)
        shouldStartActivity.postValue(intent)
    }
}