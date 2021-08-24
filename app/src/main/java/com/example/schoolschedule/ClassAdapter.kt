package com.example.schoolschedule

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.daily_component.view.*

class ClassAdapter: RecyclerView.Adapter<ClassAdapter.ClassViewHolder>() {

    var allClasses: List<String> = listOf(
        "1а","1б", "1в",
        "2а","2б", "2в",
        "3а","3б", "3в",
        "4а","4б", "4в",
        "5а","5б", "5в",
        "6а","6б", "6в",
        "7а","7б", "7в",
        "8а","8б", "8в",
        "9а","9б", "9в",
        "10а","10б", "10в",
        "11а","11б", "11в"
    )


    private val KEY = "key"

    class ClassViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        return ClassViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.daily_component, parent, false))
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val element = allClasses[position]
        holder.itemView.ClassFragment.text = element
        holder.itemView.ClassFragment.setOnClickListener {
            val setting = holder.itemView.context.getSharedPreferences("settings",Context.MODE_PRIVATE)
            setting.edit().putString(KEY, element).apply()
            holder.itemView.findNavController().navigate(R.id.scheldue)

        }
    }

    override fun getItemCount(): Int {
        return allClasses.count()
    }
}