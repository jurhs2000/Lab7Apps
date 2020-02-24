package com.example.laboratorio5apps

import androidx.lifecycle.ViewModel
import com.example.laboratorio5apps.models.Question
import java.util.*
import kotlin.collections.ArrayList

object MainViewModel {

    private var quiz: MutableList<Question> = mutableListOf<Question>()

    fun addDefaultQuestions() {
        val q1: Question = Question("¿Qué le pareció nuestro servicio?","")
        quiz.add(q1)
        val q2: Question = Question("¿Tiene algún comentario o sugerencia?","")
        quiz.add(q2)
    }

    fun getQuestionbyIndex(index: Int): String {
        return quiz.get(index).question
    }

    fun getAnswerbyIndex(index: Int): String {
        return quiz.get(index).answer
    }

    fun getQuizSize(): Int {
        return quiz.size
    }

    fun addNewQuestion(question: String) {
        var q1: Question = Question(question,"")
        quiz.add(q1)
    }

    fun addAnswerToQuestion(indexQuestion: Int, answer: String) {
        quiz.get(indexQuestion).answer = answer
    }

    fun addQuizToQuizes() {
        val newQuiz: ArrayList<Question> = arrayListOf<Question>()
        for (q in quiz) {
            val q1: Question = Question(q.question,q.answer)
            newQuiz.add(q1)
        }
        Results.addQuiz(newQuiz)
    }

    fun toStringFormat(): String {
        var result = ""
        for(i in 0..(quiz.size - 1)) {
            result += "Pregunta " + (i + 1) + ": "
            result += quiz.get(quiz.size - i - 1).question
            result += "\n"
        }
        return result
    }

}