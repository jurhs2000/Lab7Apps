package com.example.laboratorio5apps.models

class Question {

    constructor(question: String, answer: String) {
        this.question = question
        this.answer = answer
    }

    var question: String = ""
        get() = field
        set(value) { field = value }

    var answer: String = ""
        get() = field
        set(value) { field = value }

}