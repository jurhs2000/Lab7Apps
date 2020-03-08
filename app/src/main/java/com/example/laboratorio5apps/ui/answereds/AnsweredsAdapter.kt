package com.example.laboratorio5apps.ui.answereds

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio5apps.R
import com.example.laboratorio5apps.models.entities.Answer
import com.example.laboratorio5apps.models.entities.Question

class AnsweredsAdapter internal constructor(context: Context): RecyclerView.Adapter<AnsweredsAdapter.ViewHolderData>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var answers = emptyList<Answer>() // Cached copy of words
    private var questions = emptyList<Question>()

    inner class ViewHolderData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idPoll: TextView = itemView.findViewById(R.id.idPollCard)
        val idAnswer: TextView = itemView.findViewById(R.id.idAnswerCard)
        val questionAnswer: TextView = itemView.findViewById(R.id.questionAnswerCard)
        val answerText: TextView = itemView.findViewById(R.id.answerTextCard)
        val answerNumber: TextView = itemView.findViewById(R.id.answerNumberCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        val itemView = inflater.inflate(R.layout.list_answereds_recycler, parent, false)
        return ViewHolderData(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        val current = answers[position]
        holder.idPoll.text = "Encuesta " + current.pollId.toString()
        holder.idAnswer.text = "Respuesta " + current.id.toString()
        holder.questionAnswer.text = "pregunta: " + questions.find { q -> q.id == current.questionId }!!.question
        holder.answerText.text = "respuesta texto: " + current.answerText
        holder.answerNumber.text = "respuesta numero: " + current.answerNumber.toString()
    }

    internal fun setQuestions(questions: List<Question>) {
        this.questions = questions
        notifyDataSetChanged()
    }

    internal fun setAnswers(answers: List<Answer>) {
        this.answers = answers
        notifyDataSetChanged()
    }

    override fun getItemCount() = answers.size
}