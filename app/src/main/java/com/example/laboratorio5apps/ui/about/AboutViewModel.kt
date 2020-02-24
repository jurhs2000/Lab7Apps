package com.example.laboratorio5apps.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = "Julio Roberto Herrera Saban 19402"
    }
    val name: LiveData<String> = _name
    private val _course = MutableLiveData<String>().apply {
        value = "Apps y Videojuegos - Laboratorio 5"
    }
    val course: LiveData<String> = _course
    private val _description = MutableLiveData<String>().apply {
        value = "Aplicacion de encuestas utilizando LiveData y Navigations"
    }
    val description: LiveData<String> = _description
}