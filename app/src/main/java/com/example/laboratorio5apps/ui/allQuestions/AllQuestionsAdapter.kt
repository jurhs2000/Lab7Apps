package com.example.laboratorio5apps.ui.allQuestions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.models.entities.Question

class AllQuestionsAdapter internal constructor(context: Context): RecyclerView.Adapter<AllQuestionsAdapter.ViewHolderData>() {

    /**
    lateinit var datos: ArrayList<String>

    constructor(datos: ArrayList<String>) : this() {
        this.datos = datos
    }

//
    class ViewHolderData(itemView: View) : RecyclerView.ViewHolder(itemView)

//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_question_recycler,parent,false)
        return ViewHolderData(view)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        holder.itemView.idData.text = datos.get(position)
    }
    */
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var questions = emptyList<Question>() // Cached copy of words

    inner class ViewHolderData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idQuestion: TextView = itemView.findViewById(R.id.idQuestionCard)
        val question: TextView = itemView.findViewById(R.id.questionCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        val itemView = inflater.inflate(R.layout.list_question_recycler, parent, false)
        return ViewHolderData(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        val current = questions[position]
        holder.idQuestion.text = current.id.toString()
        holder.question.text = current.question
    }

    internal fun setQuestions(questions: List<Question>) {
        this.questions = questions
        notifyDataSetChanged()
    }

    override fun getItemCount() = questions.size
}