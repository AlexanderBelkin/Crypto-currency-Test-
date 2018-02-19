package com.example.air.cryptocurrency.data

import com.example.air.cryptocurrency.data.api.CurrencyApi
import javax.inject.Inject

class DataManager @Inject constructor(retrofit: CurrencyApi) : IDataManager {
}