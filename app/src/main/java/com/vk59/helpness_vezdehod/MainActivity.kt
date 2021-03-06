package com.vk59.helpness_vezdehod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    companion object {
        var backButtonToolbar: ImageView? = null
        var uploadButtonToolbar: ImageView? = null
        var toolbarTitle : TextView? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setCustomView(R.layout.toolbar)
        supportActionBar!!.elevation = 0F

        backButtonToolbar = findViewById(R.id.backButtonToolbar)
        uploadButtonToolbar = findViewById(R.id.uploadButtonToolbar)
        toolbarTitle = findViewById(R.id.toolbarTitle)
    }
}