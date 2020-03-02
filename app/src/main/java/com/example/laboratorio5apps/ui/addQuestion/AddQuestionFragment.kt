package com.example.laboratorio5apps.ui.addQuestion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio5apps.MainViewModel
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.databinding.FragmentAddQuestionBinding
import com.example.laboratorio5apps.models.entities.Question


class AddQuestionFragment : Fragment() {

    private lateinit var addQuestionViewModel: AddQuestionViewModel
    private lateinit var binding: FragmentAddQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        addQuestionViewModel = ViewModelProviders.of(this).get(AddQuestionViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentAddQuestionBinding>(
                inflater, R.layout.fragment_add_question, container, false
        )
        binding.setLifecycleOwner(this)
        binding.model = addQuestionViewModel
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.save_bar -> {
            // User chose the "Settings" item, show the app settings UI...
            if (TextUtils.isEmpty(binding.etNewQuestion.text)) {
                Toast.makeText(context, "Ingrese la pregunta a guardar", Toast.LENGTH_SHORT).show()
                false
            } else {
                addQuestionViewModel.insert(Question(0,binding.etNewQuestion.text.toString(),1,false))
                Toast.makeText(context, "Se guardo la pregunta", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(R.id.action_nav_add_question_to_nav_home)
                //cerrar teclado
                val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view?.windowToken, 0)
                true
            }
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}