package com.example.hw4.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


//https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John

/*
.addHeader("X-RapidAPI-Key", "62046210eamshb1039cc3a834d5ep160059jsn329f9fbbe521")
.addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")*/

interface LoveApi {
    @GET("getPercentage")
    fun getLove(@Query("sname")secondName:String,@Query("fname")firstName:String,
                @Header("X-RapidAPI-Key")key:String ="62046210eamshb1039cc3a834d5ep160059jsn329f9fbbe521",
                @Header("X-RapidAPI-Host")host: String="love-calculator.p.rapidapi.com"): Call<LoveModel>
}