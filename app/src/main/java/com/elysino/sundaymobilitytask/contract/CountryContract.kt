package com.elysino.sundaymobilitytask.contract

import com.elysino.sundaymobilitytask.model.CountryModel
import android.content.Intent
import java.util.ArrayList

interface CountryContract {
    interface View {
        fun showProgressBar()
        fun hideProgressBar()
        fun addItems(arrayList: ArrayList<CountryModel?>)
        val isActive: Boolean?
        fun moveToNextScreen(intent: Intent?, isFinish: Boolean?)
    }

    interface Presenter {
        fun start()
    }
}