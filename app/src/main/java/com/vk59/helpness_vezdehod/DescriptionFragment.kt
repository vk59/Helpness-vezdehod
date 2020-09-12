package com.vk59.helpness_vezdehod

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController


class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_description, container, false)
        val navController: NavController = findNavController()
        MainActivity.backButtonToolbar!!.setOnClickListener {
            navController.navigate(R.id.action_descriptionFragment_to_newsFragment)
        }
        MainActivity.uploadButtonToolbar!!.visibility = View.INVISIBLE

        MainActivity.toolbarTitle!!.text = "Сделаем мир лучше"

        val progressBar: ProgressBar = view.findViewById(R.id.progressBarDes)
        progressBar.setProgress(99, false)

        val donate: Button = view.findViewById(R.id.donate)
        donate.setOnClickListener {
            goToUrl()
        }

        return view
    }

    private fun goToUrl() {
        val uriUrl: Uri = Uri.parse("https://vk.com/vank78?w=wall125483792_9689")
        val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
        startActivity(launchBrowser)
    }
}