package com.example.nudgeinterview

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowManager
import android.widget.EditText

class RequestFocusActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val editText = findViewById<EditText>(androidx.core.R.id.text)
        editText.requestFocus()

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
    }

}