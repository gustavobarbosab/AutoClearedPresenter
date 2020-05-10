package com.gustavobarbosab.autodispose.ui.third

import com.gustavobarbosab.autoclearedpresenter.AutoClearedPresenter
import com.gustavobarbosab.autodispose.data.PersonAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ThirdPresenter(
    view: ThirdContract.View,
    val api: PersonAPI
) : AutoClearedPresenter<ThirdContract.View>(view),
    ThirdContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadPeople() {
        val disposable =
            api
                .getPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { view?.showLoading() }
                .doOnTerminate { view?.hideLoading() }
                .subscribe({ view?.showPeople(it) }, {})
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        view?.showToastDestroyed()
        compositeDisposable.dispose()
        super.onCleared()
    }
}