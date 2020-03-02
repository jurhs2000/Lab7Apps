package com.example.laboratorio5apps

import com.example.laboratorio5apps.models.entities.Question

object Results {

    private var quizes: ArrayList<ArrayList<Question>> = arrayListOf()

    fun addQuiz(quiz: ArrayList<Question>) {
        quizes.add(quiz)
    }

    fun getQuizesSize(): Int {
        return quizes.size
    }

    fun getQuizByIndex(index: Int): ArrayList<Question> {
        return quizes.get(index)
    }

    fun getRating() : Double {
        var rating: Double = 0.0
        for (quiz in quizes) {
            //rating = rating + quiz.get(0).answer.toDouble()
        }
        rating = rating/ quizes.size
        return rating
    }

    fun toStringFormat(): String {
        var result = ""
        for(i in 0..(quizes.size - 1)) {
            result += "Encuesta " + (i+1) +":\n"
            for(j in 0..(quizes.get(i).size - 1)) {
                //result += " - " + quizes.get(i).get(j).question + " : " + quizes.get(i).get(j).answer
            }
            result += "\n"
        }
        return result
    }
}