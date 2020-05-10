package com.gustavobarbosab.autodispose.ui.second

import com.gustavobarbosab.autodispose.autocleared.AutoClearedPresenter
import com.gustavobarbosab.autodispose.ui.second.SecondContract.View
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
                    .delay(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ view?.showSuccess() }, { view?.showError() })
            )
    }

    override fun onCleared() {
        view?.showDestroyToast()
        compositeDisposable.dispose()
        super.onCleared()
    }
}