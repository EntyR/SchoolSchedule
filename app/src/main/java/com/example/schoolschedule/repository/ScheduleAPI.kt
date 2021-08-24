package com.example.schoolschedule.repository

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object ScheduleAPI {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://ydg7k.mocklab.io")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    fun createSchService(): ISchedule{
        return retrofit.create(ISchedule::class.java)
    }

}
interface ISchedule{
    @GET("/schedule/json")
    fun getSchedule(): Call<scArray>
}