package com.vk59.helpness_vezdehod

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_additionally.*
import java.util.*

class AdditionallyFragment : Fragment() {

    var dateText: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_additionally, container, false)
        MainActivity.toolbarTitle!!.text = getString(R.string.titleAdditionally)
        val navController: NavController = findNavController()
        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_additionallyFragment_to_formDonationFragment)
        }

        val spinnerCreator: Spinner = view.findViewById(R.id.spinnerCreator)
        val cards = arrayListOf("Ваня Костылев", "Ирина Суязова", "Егор Кондрашов", "Руслан Сулейманов")
        val langAdapter: ArrayAdapter<CharSequence> = ArrayAdapter(requireContext(), R.layout.spinner_text,
            cards as List<CharSequence>
        )
        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown)
        spinnerCreator.adapter = langAdapter

        val createButton: Button = view.findViewById(R.id.createButton)
        createButton.setOnClickListener {
            navController.navigate(R.id.action_additionallyFragment_to_postingFragment)
        }
        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioGotSum -> {
                    createButton.alpha = 1f
                    createButton.isEnabled = true
                    chooseDateTitle!!.visibility = View.INVISIBLE
                    dateText!!.visibility = View.INVISIBLE
                }
                R.id.radioDate -> {
                    if (dateText!!.text == "Выберите дату") {
                        createButton.alpha = 0.6f
                        createButton.isEnabled = false
                    }
                    chooseDateTitle!!.visibility = View.VISIBLE
                    dateText!!.visibility = View.VISIBLE
                }
            }
        }

        dateText = view.findViewById(R.id.chooseDate)
        dateText!!.setOnClickListener {
            setDate(view)
            if (dateText!!.text != "") {
                createButton.isEnabled = true
                createButton.alpha = 1f
            }
        }

        return view
    }

    private fun setDate(view: View?)  {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog: Unit = DatePickerDialog(requireView().context,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                dateText!!.text = "$dayOfMonth.$month.$year"
            }, year, month, day).show()
    }

}
