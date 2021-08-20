package com.elysino.sundaymobilitytask.contract

import android.content.Intent
import com.elysino.sundaymobilitytask.model.Player
import java.util.*

interface PlayerContract {
    interface View {
        fun addItems(arrayList: ArrayList<Player?>?)
        val isActive: Boolean?
        fun sortByFirstName(arrayList: ArrayList<Player?>?)
        fun sortByLastName(arrayList: ArrayList<Player?>?)
    }

    interface Presenter {
        fun start(intent: Intent?)
        fun sortByFirstName()
        fun sortByLastName()
    }
}