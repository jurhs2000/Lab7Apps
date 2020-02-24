package com.example.laboratorio5apps.ui.answereds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio5apps.Results

class AnsweredsModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = Results.toStringFormat()
    }
    val text: LiveData<String> = _text
}