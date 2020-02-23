package com.example.laboratorio5apps.ui.allQuestions

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio5apps.R
import kotlinx.android.synthetic.main.list_question_recycler.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*

class AdapterData() : RecyclerView.Adapter<AdapterData.ViewHolderData>() {

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
//
}