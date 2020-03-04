package com.example.laboratorio5apps.repositories

import androidx.lifecycle.LiveData
import com.example.laboratorio5apps.models.DAOs.PollDAO
import com.example.laboratorio5apps.models.DAOs.QuestionDAO
import com.example.laboratorio5apps.models.entities.Poll
import com.example.laboratorio5apps.models.entities.Question
import kotlinx.coroutines.*

class PollRepository(val pollDAO: PollDAO) {

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
            getLastId()
        }
    }

    //Data
    //obtiene todas nomas asi por la igualacion
    val allPolls: LiveData<List<Poll>> = pollDAO.getAll()
    var lastId: Int = -1

    //Metodos crud
    suspend fun insert(poll: Poll) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                pollDAO.insert(poll)
            }
        }
    }

    suspend fun getLastId() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val last: Int = pollDAO.getLastId()
                lastId = last
            }
        }
    }

}
