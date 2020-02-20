package com.example.laboratorio5apps.ui.addQuestion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.laboratorio5apps.R

class AddQuestionFragment : Fragment() {

    private lateinit var addQuestionModel: AddQuestionModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addQuestionModel =
            ViewModelProviders.of(this).get(AddQuestionModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_question, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        addQuestionModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}