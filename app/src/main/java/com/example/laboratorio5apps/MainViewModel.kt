package com.example.laboratorio5apps

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.laboratorio5apps.models.DataBase
import com.example.laboratorio5apps.models.entities.Question
import com.example.laboratorio5apps.repositories.QuestionRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val questionRepository: QuestionRepository
    // LiveData gives us updated words when they change.
    val allQuestions: LiveData<List<Question>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val questionDAO = DataBase.getInstance(application, viewModelScope).questionDAO()
        questionRepository = QuestionRepository(questionDAO)
        allQuestions = questionRepository.allQuestions
    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(question: Question) = viewModelScope.launch {
        questionRepository.insert(question)
    }

    override fun onCleared() {
        super.onCleared()
        questionRepository.cancelJob()
    }
}