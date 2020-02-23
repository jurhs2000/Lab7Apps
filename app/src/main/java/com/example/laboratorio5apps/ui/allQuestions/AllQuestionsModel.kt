package com.example.laboratorio5apps.ui.allQuestions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio5apps.MainViewModel

class AllQuestionsModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text
}