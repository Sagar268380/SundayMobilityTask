package com.elysino.sundaymobilitytask.presenter

import android.content.Intent
import com.elysino.sundaymobilitytask.contract.PlayerContract
import com.elysino.sundaymobilitytask.model.Player
import java.util.*

class PlayerListPresenter(var playerView: PlayerContract.View) : PlayerContract.Presenter {
    var arrayList: ArrayList<Player?>? = ArrayList()
    override fun start(intent: Intent?) {
        getPlayerList(intent)
    }

    override fun sortByFirstName() {
        if (playerView.isActive == true) {
            playerView.sortByFirstName(arrayList)
        }
    }

    override fun sortByLastName() {
        if (playerView.isActive == true) {
            playerView.sortByLastName(arrayList)
        }
    }

    private fun getPlayerList(intent: Intent?) {
        if (playerView.isActive == true) {
            arrayList = intent?.getSerializableExtra("player_list") as ArrayList<Player?>?
            playerView.addItems(arrayList)
        }
    }
}