package org.algosketch.alcabulary.mvvm.feature.example

import android.icu.util.BuddhistCalendar
import android.os.Bundle
import android.os.Looper
import android.os.Message
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import org.algosketch.alcabulary.mvvm.global.MyApplication
import org.algosketch.alcabulary.mvvm.model.db.AppDatabase
import java.util.logging.Handler

class StudyExampleViewModel : ViewModel() {
    private val _exampleSentence: MutableLiveData<String> = MutableLiveData<String>("놀랍게도 예문입니다.")
    val exampleSentence: LiveData<String> = _exampleSentence
    private val handler = MyHandler(Looper.getMainLooper())

    fun setVocabulary() {
        Thread {
            val db = Room.databaseBuilder(
                MyApplication.ApplicationContext(),
                AppDatabase::class.java,
                "vocabulary"
            ).build()

            // 데이터 흭득
            val dao = db.VocabularyDao()
            val newSentence = dao.getAll()[0].exampleSentence.toString()

            // 메시지 생성
            val bundle = Bundle()
            bundle.putString("exampleSentence", newSentence)
            val msg = Message()
            msg.data = bundle

            // 예문 출력
            handler.sendMessage(msg)
        }.start()
    }

    inner class MyHandler(looper: Looper) : android.os.Handler(looper) {
        override fun handleMessage(msg: Message) {
            _exampleSentence.value = msg.data.getString("exampleSentence", "놀랍게도 예문")
        }
    }
}