package com.example.retrofly.services

import android.os.Build
import android.os.LocaleList
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.create
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit
import java.util.*


object ServiceBuilder {
    private const val  URL="http://127.0.0.1:3000/"
    private val okHttp: OkHttpClient.Builder=OkHttpClient.Builder()

    private val logger= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
   // private val okhttp=OkHttpClient.Builder().addInterceptor(logger).build()



   /* private val builder:Retrofit.Builder=Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp.build())

    private val retrofit:Retrofit= builder.build()*/
   /*var gson = GsonBuilder()
       .setLenient()
       .create()

    var retrofit2: Retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .client(okhttp)

        .build()*/

    //interceptor


    var gson = GsonBuilder().setLenient().create()

        //private val okhttp=OkHttpClient.Builder().addInterceptor(logger).build()
        //private val client = OkHttpClient.Builder().addInterceptor( headerInterceptor).addInterceptor(logger)
      /*  val headInterceptor = object :Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                var request=chain.request()
                request=request.newBuilder()
                    .addHeader("x-device-type", Build.DEVICE)
                    .addHeader("Accept-Language", Locale.getDefault().language)
                    .build()
                val response=chain.proceed(request)
                return response
            }*/

        val HeaderInterceptor=object:Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                 var request=chain.request()
                request=request.newBuilder()
                    .addHeader("x-device-type", Build.DEVICE)
                    .addHeader("Accept-Language", Locale.getDefault().language)
                    .build()
                val response=chain.proceed(request)
                return response
            }

        }
        private val client=OkHttpClient.Builder().addInterceptor(HeaderInterceptor).addInterceptor(logger).build()

        var retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    fun<T> buildService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }




    }




