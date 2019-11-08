package com.darax.futblen.activities.detail

import com.darax.futblen.model.Teams

interface DetailView {

    interface View{
        fun displayTeamBadgeHome(team: Teams)
        fun displayTeamBadgeAway(team: Teams)
    }

    interface Presenter{
        fun getTeamsBadgeAway(id:String)
        fun getTeamsBadgeHome(id:String)
    }
}