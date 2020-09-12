package com.vk59.helpness_vezdehod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class FormDonationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form_donation, container, false)

        val navController: NavController = findNavController()

        MainActivity.toolbarTitle!!.text = getString(R.string.titileFormDonation)
        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_formDonationFragment_to_chooseTypeFragment)
        }

        val spinner: Spinner = view.findViewById(R.id.spinner)
        val cards = arrayListOf("Pay VK . 1234", "Sberbank ***2345", "MIR ***9876")
        val langAdapter: ArrayAdapter<CharSequence> = ArrayAdapter(requireContext(), R.layout.spinner_text,
            cards as List<CharSequence>
        )
        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown)
        spinner.adapter = langAdapter

        val continueButton: Button = view.findViewById(R.id.continueButton)
        continueButton.setOnClickListener {
            if (view.findViewById<EditText>(R.id.editAim).text.toString() != ""
                && view.findViewById<EditText>(R.id.editSum).text.toString() != ""
                && view.findViewById<EditText>(R.id.editDescription).text.toString() != ""
                && view.findViewById<EditText>(R.id.editName).text.toString() != ""
            ) {
                navController.navigate(R.id.action_formDonationFragment_to_additionallyFragment)
            } else {
                Snackbar.make(view, "Заполните все поля!", Snackbar.LENGTH_SHORT).show()
            }
        }

        return view
    }
}