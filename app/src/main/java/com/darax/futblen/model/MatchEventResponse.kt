package com.darax.futblen.model

import com.google.gson.annotations.SerializedName

data class MatchEventResponse (
        @SerializedName("events") var events: List<MatchEvent>)
