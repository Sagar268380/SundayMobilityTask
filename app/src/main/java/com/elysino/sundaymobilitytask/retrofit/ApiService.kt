package com.elysino.sundaymobilitytask.retrofit

import com.elysino.sundaymobilitytask.apiresponse.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("players.json")
    open fun getCountry(): Call<CountryResponse?>
}