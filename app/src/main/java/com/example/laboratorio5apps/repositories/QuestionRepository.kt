package com.example.laboratorio5apps.repositories

//tener las preguntas
//agregar las 2 preguntas defecto
//obtener pregunta por id
//obtener la cantidad de todas las preguntas
//agregar una nueva pregunta
//agregar respuesta a pregunta
//agregar respuesta a encuesta

/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laboratorio5apps.models.DAOs.QuestionDAO
import com.example.laboratorio5apps.models.entities.Question
import kotlinx.coroutines.*

class QuestionRepository(val questionDAO: QuestionDAO) {

    //Aplicaciones con Job y uiScope
    private var viewModelJob = Job()

    fun cancelJob() {
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    //init
    init {
        initialize()
    }

    fun initialize() {
        uiScope.launch {
            getCount()
        }
    }

    //Data
    //obtiene todas nomas asi por la igualacion
    val allQuestions = questionDAO.getAll()
    var count: Int = -1
    //lateinit var question: LiveData<Question>

    //Metodos crud
    suspend fun insert(question: Question) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                questionDAO.insert(question)
            }
        }
    }

    suspend fun getQuestion(id: Long): Question? {
        return withContext(Dispatchers.IO) {
            val question = questionDAO.get(id)
            question
        }
    }

    suspend fun getCount() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val size: Int = questionDAO.count()
                count = size
            }
        }
    }

}
