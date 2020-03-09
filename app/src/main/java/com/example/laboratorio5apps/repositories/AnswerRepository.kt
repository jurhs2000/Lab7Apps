package com.example.laboratorio5apps.repositories

import androidx.lifecycle.LiveData
import com.example.laboratorio5apps.models.DAOs.AnswerDAO
import com.example.laboratorio5apps.models.DAOs.QuestionDAO
import com.example.laboratorio5apps.models.entities.Answer
import com.example.laboratorio5apps.models.entities.Question
import kotlinx.coroutines.*

class AnswerRepository(val answerDAO: AnswerDAO) {

    //Aplicaciones con Job y uiScope
    private var viewModelJob = Job()

    fun cancelJob() {
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    //Data
    //obtiene todas nomas asi por la igualacion
    val allAnswers: LiveData<List<Answer>> = answerDAO.getAll()
    val rating = answerDAO.ratingMean()

    //Metodos crud
    suspend fun insert(answer: Answer) {
        withContext(Dispatchers.IO) {
            answerDAO.insert(answer)
        }
    }

}
