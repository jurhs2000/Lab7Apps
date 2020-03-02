package com.example.laboratorio5apps.ui.answereds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.databinding.FragmentAnsweredsBinding

class AnsweredsFragment : Fragment() {

    private lateinit var answeredsViewModel: AnsweredsViewModel
    private lateinit var binding: FragmentAnsweredsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        answeredsViewModel =
            ViewModelProviders.of(this).get(AnsweredsViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentAnsweredsBinding>(
            inflater, R.layout.fragment_answereds, container, false)
        binding.model = answeredsViewModel
        answeredsViewModel.allQuestions.observe(this, Observer { questions->
            Toast.makeText(context, questions.size.toString(), Toast.LENGTH_LONG).show()
        })
        return binding.root
    }
}