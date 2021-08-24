package com.example.schoolschedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolschedule.repository.daily
import kotlinx.android.synthetic.main.subject.view.*

class SubjectAdapter(list: List<daily>): RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    val  subjects: List<daily> = list

    class SubjectViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        return  SubjectViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject, parent, false))
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.itemView.textView2.text = subjects[position].sb
        holder.itemView.textView4.text ="Каб. №" + subjects[position].room
    }

    override fun getItemCount(): Int {
        return subjects.count()
    }
}