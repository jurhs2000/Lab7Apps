package com.example.laboratorio5apps.ui.addQuestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddQuestionViewModel : ViewModel() {

    private val _question = MutableLiveData<String>().apply {
        value = ""
    }

    val question: LiveData<String>
        get() = _question
}