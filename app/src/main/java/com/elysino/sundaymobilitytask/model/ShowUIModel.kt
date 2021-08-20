package com.elysino.sundaymobilitytask.model

import com.elysino.sundaymobilitytask.contract.ShowUIContract
import java.util.*

class ShowUIModel : ShowUIContract.Model {

    override val data: ArrayList<DummyParentDataItem?>
        get() {
            val arrDummyData = ArrayList<DummyParentDataItem?>()
            var childDataItems: ArrayList<DummyChildDataItem?>?

            childDataItems = ArrayList()
            childDataItems.add(DummyChildDataItem("1.1   Climate Condition"))
            childDataItems.add(DummyChildDataItem("1.2   Suitable Soul"))
            childDataItems.add(DummyChildDataItem("1.2   Banana variety"))
            childDataItems.add(DummyChildDataItem("1.4   Land Preparation"))
            arrDummyData.add(DummyParentDataItem("Important of banana", "01", childDataItems))

            childDataItems = ArrayList()
            childDataItems.add(DummyChildDataItem("2.1   Climate Condition"))
            childDataItems.add(DummyChildDataItem("2.2   Suitable Soul"))
            childDataItems.add(DummyChildDataItem("2.2   Banana variety"))
            childDataItems.add(DummyChildDataItem("2.4   Land Preparation"))
            arrDummyData.add(DummyParentDataItem("Important of Soul", "02", childDataItems))

            childDataItems = ArrayList()
            childDataItems.add(DummyChildDataItem("3.1   Climate Condition"))
            childDataItems.add(DummyChildDataItem("3.2   Suitable Soul"))
            childDataItems.add(DummyChildDataItem("3.2   Banana variety"))
            childDataItems.add(DummyChildDataItem("3.4   Land Preparation"))
            arrDummyData.add(DummyParentDataItem("Title", "03", childDataItems))

            childDataItems = ArrayList()
            childDataItems.add(DummyChildDataItem("4.1   Climate Condition"))
            childDataItems.add(DummyChildDataItem("4.2   Suitable Soul"))
            childDataItems.add(DummyChildDataItem("4.2   Banana variety"))
            childDataItems.add(DummyChildDataItem("4.4   Land Preparation"))
            arrDummyData.add(DummyParentDataItem("Title", "04", childDataItems))

            childDataItems = ArrayList()
            childDataItems.add(DummyChildDataItem("5.1   Climate Condition"))
            childDataItems.add(DummyChildDataItem("5.2   Suitable Soul"))
            childDataItems.add(DummyChildDataItem("5.2   Banana variety"))
            childDataItems.add(DummyChildDataItem("5.4   Land Preparation"))
            arrDummyData.add(DummyParentDataItem("Final Assesment", "05", childDataItems))

            childDataItems = ArrayList()
            childDataItems.add(DummyChildDataItem("6.1   Climate Condition"))
            childDataItems.add(DummyChildDataItem("6.2   Suitable Soul"))
            childDataItems.add(DummyChildDataItem("6.2   Banana variety"))
            childDataItems.add(DummyChildDataItem("6.4   Land Preparation"))
            arrDummyData.add(DummyParentDataItem("Summary", "06", childDataItems))
            return arrDummyData
        }
}