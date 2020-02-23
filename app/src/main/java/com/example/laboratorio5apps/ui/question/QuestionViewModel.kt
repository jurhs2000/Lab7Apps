package com.example.laboratorio5apps.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio5apps.MainViewModel

class QuestionViewModel : ViewModel() {

    private val _count = MutableLiveData<Int>().apply {
        value = MainViewModel.getQuizSize() - 1
    }
    val count: LiveData<Int>
        get() = _count

    private val _question = MutableLiveData<String>().apply {
        value = MainViewModel.getQuestionbyIndex(_count.value!!)
    }
    val question: LiveData<String>
        get() = _question

    fun next() {
        _count.value = (_count.value!!).minus(1)
        if (_count.value!! >= 0) {
            _question.value = MainViewModel.getQuestionbyIndex(_count.value!!)
        }
    }

}