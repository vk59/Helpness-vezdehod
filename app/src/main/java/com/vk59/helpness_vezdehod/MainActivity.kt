package com.vk59.helpness_vezdehod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    companion object {
        var backButtonToolbar: ImageView? = null
        var uploadButtonToolbar: ImageView? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setCustomView(R.layout.toolbar)
        backButtonToolbar = findViewById(R.id.backButtonToolbar)
        uploadButtonToolbar = findViewById(R.id.uploadButtonToolbar)
    }
}