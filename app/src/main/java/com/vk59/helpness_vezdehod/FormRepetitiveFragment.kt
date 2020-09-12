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


class FormRepetitiveFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form_repetitive, container, false)

        val navController: NavController = findNavController()

        MainActivity.toolbarTitle!!.text = getString(R.string.regularDonation)
        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_formDonationFragment_to_chooseTypeFragment)
        }

        val spinner: Spinner = view.findViewById(R.id.spinner2)
        val cards = arrayListOf("Pay VK . 1234", "Sberbank ***2345", "MIR ***9876")
        val langAdapter: ArrayAdapter<CharSequence> = ArrayAdapter(requireContext(), R.layout.spinner_text,
            cards as List<CharSequence>
        )
        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown)
        spinner.adapter = langAdapter

        val continueButton: Button = view.findViewById(R.id.continueButton2)
        continueButton.setOnClickListener {
            if (view.findViewById<EditText>(R.id.editAim2).text.toString() != ""
                && view.findViewById<EditText>(R.id.editSum2).text.toString() != ""
                && view.findViewById<EditText>(R.id.editDescription2).text.toString() != ""
                && view.findViewById<EditText>(R.id.editName2).text.toString() != ""
            ) {
                navController.navigate(R.id.action_formRepetitiveFragment_to_postingFragment)
            } else {
                Snackbar.make(view, "Заполните все поля!", Snackbar.LENGTH_SHORT).show()
            }
        }

        val spinnerCreator: Spinner = view.findViewById(R.id.spinnerCreator2)
        val cards2 = arrayListOf("Ваня Костылев", "Ирина Суязова", "Егор Кондрашов", "Руслан Сулейманов")
        val langAdapter2: ArrayAdapter<CharSequence> = ArrayAdapter(requireContext(), R.layout.spinner_text,
            cards2 as List<CharSequence>
        )
        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown)
        spinnerCreator.adapter = langAdapter2

        return view
    }
}