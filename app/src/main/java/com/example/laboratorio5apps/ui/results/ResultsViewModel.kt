package com.example.laboratorio5apps.ui.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Resultados"
    }
    val text: LiveData<String> = _text

    private val _rating = MutableLiveData<Double>().apply {
        //value = Results.getRating()
    }
    val rating: LiveData<Double> = _rating




}