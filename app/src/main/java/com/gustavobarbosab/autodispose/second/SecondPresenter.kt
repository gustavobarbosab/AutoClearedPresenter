package com.gustavobarbosab.autodispose.second

import android.util.Log
import com.gustavobarbosab.autodispose.AutoClearedPresenter
import com.gustavobarbosab.autodispose.second.SecondContract.View
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SecondPresenter(view: View) : AutoClearedPresenter<View>(view), SecondContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getNamesFromService() {
        compositeDisposable
            .add(
                Completable
                    .complete()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .delay(5, TimeUnit.SECONDS)
                    .subscribe({ view?.showSuccess() }, { view?.showError() })
            )
    }

    override fun onCleared() {
        view?.showDestroyToast()
        compositeDisposable.dispose()
        super.onCleared()
    }
}