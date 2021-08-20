package com.elysino.sundaymobilitytask.presenter

import com.elysino.sundaymobilitytask.contract.ShowUIContract
import com.elysino.sundaymobilitytask.model.DummyParentDataItem
import java.util.*

class ShowUIPresenter(var model: ShowUIContract.Model, var view: ShowUIContract.View) : ShowUIContract.Presenter {
    var arrayList: ArrayList<DummyParentDataItem?>? = null

    override fun start() {
        arrayList = model.data
        if (view.isActive == true)
            view.addItems(arrayList)
    }
}