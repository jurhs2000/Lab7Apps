package com.example.laboratorio5apps.ui.answereds

import android.app.Application
import androidx.lifecycle.*
import com.example.laboratorio5apps.models.DataBase
import com.example.laboratorio5apps.models.entities.Answer
import com.example.laboratorio5apps.models.entities.Question
import com.example.laboratorio5apps.repositories.AnswerRepository
import com.example.laboratorio5apps.repositories.QuestionRepository

class AnsweredsViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val questionRepository: QuestionRepository
    private val answerRepository: AnswerRepository
    // LiveData gives us updated words when they change.
    val allQuestions: LiveData<List<Question>>
    val allAnswers: LiveData<List<Answer>>

    init {
        // Gets reference to QuestionDAO from RoomDatabase to construct
        // the correct QuestionRepository.
        val questionDAO = DataBase.getInstance(application, viewModelScope).questionDAO()
        questionRepository = QuestionRepository(questionDAO)
        allQuestions = questionRepository.allQuestions

        val answerDAO = DataBase.getInstance(application, viewModelScope).answerDAO()
        answerRepository = AnswerRepository(answerDAO)
        allAnswers = answerRepository.allAnswers
    }

    override fun onCleared() {
        super.onCleared()
        questionRepository.cancelJob()
    }
}