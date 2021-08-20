package com.elysino.sundaymobilitytask.presenter

import android.util.Log
import com.elysino.sundaymobilitytask.apiresponse.CountryResponse
import com.elysino.sundaymobilitytask.contract.CountryContract
import com.elysino.sundaymobilitytask.model.CountryModel
import com.elysino.sundaymobilitytask.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import java.util.*

class CountryPresenter(var homeView: CountryContract.View) : CountryContract.Presenter {
    var arrayList = ArrayList<CountryModel?>()

    override fun start() {
        getCountryData()
    }

    private fun getCountryData() {
        if (homeView != null && homeView.isActive == true) {
            homeView.showProgressBar()
        }

        val call = RetrofitClient.getInstance().myApi.getCountry()

        call.enqueue(object : retrofit2.Callback<CountryResponse?> {
            override fun onResponse(call: Call<CountryResponse?>, response: Response<CountryResponse?>) {
                if (homeView != null && homeView.isActive!!) {
                    homeView.hideProgressBar()
                }
                if (response.body()?.afghanistan != null) {
                    arrayList.add(CountryModel("Afghanistan", ArrayList(response.body()!!.afghanistan)))
                }
                if (response.body()?.australia != null) {
                    arrayList.add(CountryModel("Australia", ArrayList(response.body()?.australia)))
                }
                if (response.body()?.bangladesh != null) {
                    arrayList.add(CountryModel("Bangladesh", ArrayList(response.body()?.bangladesh)))
                }
                if (response.body()?.england != null) {
                    arrayList.add(CountryModel("England", ArrayList(response.body()?.england)))
                }
                if (response.body()?.india != null) {
                    arrayList.add(CountryModel("India", ArrayList(response.body()?.india)))
                }
                if (response.body()?.newZealand != null) {
                    arrayList.add(CountryModel("New Zealand", ArrayList(response.body()?.newZealand)))
                }
                if (response.body()?.pakistan != null) {
                    arrayList.add(CountryModel("Pakistan", ArrayList(response.body()?.pakistan)))
                }
                if (response.body()?.southAfrica != null) {
                    arrayList.add(CountryModel("South Africa", ArrayList(response.body()?.southAfrica)))
                }
                if (response.body()?.sriLanka != null) {
                    arrayList.add(CountryModel("Sri Lanka", ArrayList(response.body()?.sriLanka)))
                }
                if (response.body()?.westIndies != null) {
                    arrayList.add(CountryModel("West Indies", ArrayList(response.body()?.westIndies)))
                }

                if (homeView != null && homeView.isActive == true) {
                    arrayList.sortBy { countryModel: CountryModel? ->
                        countryModel?.countryName
                    }
                    homeView.addItems(arrayList)
                }
            }

            override fun onFailure(call: Call<CountryResponse?>, t: Throwable) {
                Log.d("error", "onFailure: " + t.message)
                homeView.hideProgressBar()
            }
        })
    }
}