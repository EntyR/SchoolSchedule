package com.example.schoolschedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolschedule.repository.ScheduleModel
import kotlinx.android.synthetic.main.sch_daily.view.*

class ScheldueAdapter: RecyclerView.Adapter<ScheldueAdapter.ScVHolder>() {

    var daily = emptyList<ScheduleModel>()

    class ScVHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScVHolder {
        return ScVHolder(LayoutInflater.from(parent.context).inflate(R.layout.sch_daily, parent, false))
    }

    override fun onBindViewHolder(holder: ScVHolder, position: Int) {
        holder.itemView.textView.text = daily[position].Date
        holder.itemView.recyclerView.adapter = SubjectAdapter(daily[position].Subjects)
        holder.itemView.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
    }

    fun setItem(list:List<ScheduleModel>){
        daily = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return daily.size
    }

}