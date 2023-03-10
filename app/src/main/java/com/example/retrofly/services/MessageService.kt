package com.example.retrofly.services

import com.example.retrofly.models.Destination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface MessageService {

    @GET
    fun getMessage(@Url anotherurl:String): Call<String>


}