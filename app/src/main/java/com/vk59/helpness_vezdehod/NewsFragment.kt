package com.vk59.helpness_vezdehod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val buttonHelp: Button = view.findViewById(R.id.helpButtonSnip)
        val navController: NavController = findNavController()

        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_newsFragment_to_postingFragment)
            MainActivity.uploadButtonToolbar!!.visibility = View.INVISIBLE
        }


        buttonHelp.isEnabled = true
        buttonHelp.alpha = 1F
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        progressBar.setProgress(60, true)
        buttonHelp.setOnClickListener {
            navController.navigate(R.id.action_newsFragment_to_descriptionFragment)
        }
        return view
    }
}