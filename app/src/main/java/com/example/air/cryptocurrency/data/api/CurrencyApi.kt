package com.example.air.cryptocurrency.data.api

import com.example.air.cryptocurrency.model.AllCurrencyResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface CurrencyApi {

    @GET("ticker")
    fun getAllCurrencyApi(): Observable<ArrayList<AllCurrencyResponse>>

}