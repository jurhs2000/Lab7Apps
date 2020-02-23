package com.example.laboratorio5apps.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio5apps.MainViewModel
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private lateinit var questionViewModel: QuestionViewModel
    private lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        questionViewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_question, container, false
        )
        binding.model = questionViewModel
        binding.next.setOnClickListener{view: View ->
            questionViewModel.next()
            if (questionViewModel.count.value!! < 0) {
                view.findNavController().navigate(R.id.action_nav_question_to_nav_results)
            } else {
                Toast.makeText(context, "Faltan " + (questionViewModel.count.value!!).plus(1) + " preguntas!", Toast.LENGTH_SHORT).show()
            }
        }
        questionViewModel.question.observe(this, Observer {
            binding.question.text = it
        })
        return binding.root
    }
}