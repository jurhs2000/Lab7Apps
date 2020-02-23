package com.example.laboratorio5apps.ui.answereds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnsweredsModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is answereds Fragment"
    }
    val text: LiveData<String> = _text
}