package com.example.laboratorio5apps.ui.addQuestion

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.databinding.FragmentAddQuestionBinding
import com.example.laboratorio5apps.models.entities.Question


class AddQuestionFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var addQuestionViewModel: AddQuestionViewModel
    private lateinit var binding: FragmentAddQuestionBinding
    private var spinnerPos: Int = -1

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
        //
        val spinner: Spinner = binding.spinner
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            context,
            R.array.types_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        binding.spinner.onItemSelectedListener = this
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.save_bar -> {
            // User chose the "Settings" item, show the app settings UI...
            if (TextUtils.isEmpty(binding.etNewQuestion.text) || spinnerPos < 0) {
                Toast.makeText(context, "Ingrese la pregunta a guardar", Toast.LENGTH_SHORT).show()
                false
            } else {
                addQuestionViewModel.insert(Question(0,binding.etNewQuestion.text.toString(),spinnerPos + 1,false))
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

    override fun onItemSelected(p0: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
        spinnerPos = p2
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}