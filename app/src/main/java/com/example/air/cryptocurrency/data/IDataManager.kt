package com.example.air.cryptocurrency.data

import com.example.air.cryptocurrency.model.AllCurrencyResponse
import io.reactivex.Observable
import kotlin.collections.ArrayList

interface IDataManager {

    fun getAllCurrency(): Observable<ArrayList<AllCurrencyResponse>>

}