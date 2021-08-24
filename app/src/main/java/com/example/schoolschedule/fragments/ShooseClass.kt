package com.example.schoolschedule.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolschedule.ClassAdapter
import com.example.schoolschedule.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class ShooseClass : Fragment() {

    private val KEY = "key"
    

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_classes, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.class_recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = ClassAdapter()
        val setting = view.context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        val chosenClass = setting.getString(KEY, "ER")
        if (chosenClass != "ER"){
            findNavController().navigate(R.id.scheldue)
        }
        return view
    }



}