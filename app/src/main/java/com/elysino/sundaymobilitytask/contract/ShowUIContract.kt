package com.elysino.sundaymobilitytask.contract

import com.elysino.sundaymobilitytask.model.DummyParentDataItem
import java.util.ArrayList

interface ShowUIContract {
    interface View {
        fun addItems(arrayList: ArrayList<DummyParentDataItem?>?)
        val isActive: Boolean?
    }

    interface Model {
        val data: ArrayList<DummyParentDataItem?>?
    }

    interface Presenter {
        fun start()
    }
}