package com.example.schoolschedule.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolschedule.R
import com.example.schoolschedule.ScheldueAdapter
import com.example.schoolschedule.repository.ScheduleAPI
import com.example.schoolschedule.repository.scArray
import kotlinx.android.synthetic.main.fragment_scheldue.view.*
import retrofit2.Call
import retrofit2.Response


class Scheldue : Fragment() {


    private val KEY = "key"
    lateinit var ScClass: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_scheldue, container, false)
        val adapter = ScheldueAdapter()
        // Getting the class number
        val setting = view.context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        ScClass = setting.getString(KEY, "ER")!!
        // Getting Schedule from API
        val retrofit = ScheduleAPI.createSchService().getSchedule()
        retrofit.enqueue(object : retrofit2.Callback<scArray>{
            override fun onResponse(
                call: Call<scArray>,
                response: Response<scArray>
            ) {
                if (response.body()!=null) {
                    adapter.setItem(response.body()!!.list)
                }
            }

            override fun onFailure(call: Call<scArray>, t: Throwable) {
                Log.e("API", t.message.toString())
                Toast.makeText(requireContext(),"Ошибка соединения",Toast.LENGTH_LONG ).show()
            }

        })

        // Setting up recycler view
        view.sc_recycler.adapter = adapter
        view.sc_recycler.layoutManager = LinearLayoutManager(view.context)


        return view
    }


}