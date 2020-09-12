package com.vk59.helpness_vezdehod

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.toolbar.*


class ChooseTypeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_type, container, false)
        val buttonToForm: View = view.findViewById(R.id.aimButton)
        val buttonToRepetitiveForm: View = view.findViewById(R.id.repetitiveButton)

        val navController: NavController = findNavController()
        buttonToForm.setOnClickListener {
            Log.d("GO GO GO", "to form")
            navController.navigate(R.id.action_chooseTypeFragment_to_formDonationFragment)
        }
        buttonToRepetitiveForm.setOnClickListener {
            navController.navigate(R.id.action_chooseTypeFragment_to_formDonationFragment)
        }
        MainActivity.backButtonToolbar!!.visibility = View.VISIBLE
        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_chooseTypeFragment_to_mainFragment)
        }
        return view
    }
}