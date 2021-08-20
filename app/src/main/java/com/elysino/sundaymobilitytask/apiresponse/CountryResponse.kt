package com.elysino.sundaymobilitytask.apiresponse

import com.elysino.sundaymobilitytask.model.Player
import com.google.gson.annotations.SerializedName

class CountryResponse(
        @SerializedName("Afghanistan") var afghanistan: List<Player>,
        @SerializedName("Australia") var australia: List<Player>,
        @SerializedName("Bangladesh") var bangladesh: List<Player>,
        @SerializedName("England") var england: List<Player>,
        @SerializedName("India") var india: List<Player>,
        @SerializedName("New Zealand") var newZealand: List<Player>,
        @SerializedName("Pakistan") var pakistan: List<Player>,
        @SerializedName("South Africa") var southAfrica: List<Player>,
        @SerializedName("Sri Lanka") var sriLanka: List<Player>,
        @SerializedName("West Indies") var westIndies: List<Player>
)