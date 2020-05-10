package com.gustavobarbosab.autodispose.ui.first

import com.gustavobarbosab.autodispose.autocleared.AutoClearedPresenter
import com.gustavobarbosab.autodispose.ui.first.FirstContract.View

class FirstPresenter(view: View) : AutoClearedPresenter<View>(view), FirstContract.Presenter {

    override fun init() {
        view?.showInitToast()
    }

    override fun onCleared() {
        view?.showDestroyToast()
        super.onCleared()
    }
}