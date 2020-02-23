package com.example.laboratorio5apps.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.laboratorio5apps.R

class ResultsFragment : Fragment() {

    private lateinit var resultsViewModel: ResultsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultsViewModel =
            ViewModelProviders.of(this).get(ResultsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_results, container, false)
        val textView: TextView = root.findViewById(R.id.text_results)
        resultsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}