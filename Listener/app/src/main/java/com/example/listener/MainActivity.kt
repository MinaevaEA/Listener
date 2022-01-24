package com.example.listener

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var noteReceiver: NoteReceiver
    private lateinit var note: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        note = findViewById(R.id.note)
        noteReceiver = NoteReceiver(note)
        registerReceiver(noteReceiver, IntentFilter(ACTION))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(noteReceiver)
    }

    companion object {

        private const val ACTION = "com.example.test1.ACTION_SAVING"
    }
}

