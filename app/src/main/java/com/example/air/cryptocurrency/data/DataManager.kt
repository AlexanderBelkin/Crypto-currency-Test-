package com.example.air.cryptocurrency.data

import com.example.air.cryptocurrency.data.api.CurrencyApi
import com.example.air.cryptocurrency.model.AllCurrencyResponse
import com.example.air.cryptocurrency.model.ArrayCurrency
import io.reactivex.Observable
import javax.inject.Inject

class DataManager @Inject constructor(var retrofit: CurrencyApi) : IDataManager {

    override fun getAllCurrency(): Observable<ArrayList<AllCurrencyResponse>> {
        return retrofit.getAllCurrencyApi()
    }
}