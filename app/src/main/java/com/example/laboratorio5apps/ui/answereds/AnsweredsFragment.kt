package com.example.laboratorio5apps.ui.answereds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.databinding.FragmentAllQuestionsBinding
import com.example.laboratorio5apps.databinding.FragmentAnsweredsBinding
import com.example.laboratorio5apps.ui.allQuestions.AllQuestionsModel

class AnsweredsFragment : Fragment() {

    private lateinit var answeredsModel: AnsweredsModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        answeredsModel =
            ViewModelProviders.of(this).get(AnsweredsModel::class.java)
        val root = inflater.inflate(R.layout.fragment_answereds, container, false)
        val binding = DataBindingUtil.inflate<FragmentAnsweredsBinding>(
            inflater, R.layout.fragment_answereds, container, false)

        return binding.root
    }
}