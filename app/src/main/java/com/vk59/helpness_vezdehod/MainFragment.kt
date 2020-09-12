package com.vk59.helpness_vezdehod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val navController: NavController = findNavController()
        val createButton: Button = view.findViewById(R.id.createButton)
        createButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_chooseTypeFragment)
        }
        MainActivity.backButtonToolbar!!.visibility = View.INVISIBLE

        return view
    }


}