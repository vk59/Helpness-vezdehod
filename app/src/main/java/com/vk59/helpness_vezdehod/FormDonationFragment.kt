package com.vk59.helpness_vezdehod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class FormDonationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_type, container, false)

        val navController: NavController = findNavController()

        MainActivity.backButtonToolbar!!.visibility = View.VISIBLE
        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_formDonationFragment_to_chooseTypeFragment)
        }
        return view
    }
}