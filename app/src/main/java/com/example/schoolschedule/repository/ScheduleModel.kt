package com.example.schoolschedule.repository

data class daily(
        val sb: String,
        val room: String
)
data class ScheduleModel(val Date: String, val Subjects: List<daily>)
data class scArray(val list: List<ScheduleModel>)