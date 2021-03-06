package com.vk59.helpness_vezdehod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.toolbar.*

class PostingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_posting, container, false)

        val navController: NavController = findNavController()
        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_postingFragment_to_additionallyFragment)
            MainActivity.uploadButtonToolbar!!.visibility = View.INVISIBLE
        }

        MainActivity.uploadButtonToolbar!!.visibility = View.VISIBLE

        MainActivity.uploadButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_postingFragment_to_newsFragment)
        }

        MainActivity.toolbarTitle!!.text = "Ваня"

        return view
    }

}