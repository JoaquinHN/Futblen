package com.darax.futblen.activities.main

import com.darax.futblen.model.MatchEvent

interface MainView {

    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)
    }

    interface Presenter{
        fun getFootballMatchData()

        fun getFootballUpcomingData()
    }

}