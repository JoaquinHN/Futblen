package com.darax.futblen.activities.detail


import com.darax.futblen.model.MatchEventPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter(private val mView : DetailView.View, private val matchEventPresenter: MatchEventPresenter) : DetailView.Presenter {

    override fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayTeamBadgeHome(it.teams[0])
                })
    }

    private val compositeDisposable = CompositeDisposable()

    override fun getTeamsBadgeAway(id:String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayTeamBadgeAway(it.teams[0])
                })
    }
}