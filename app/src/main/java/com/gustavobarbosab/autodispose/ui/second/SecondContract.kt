package com.gustavobarbosab.autodispose.ui.second

import com.gustavobarbosab.autodispose.autocleared.ViewObservable

interface SecondContract {

    interface View : ViewObservable {
        fun showDestroyToast()
        fun showSuccess()
        fun showError()
    }

    interface Presenter {
        fun getNamesFromService()
    }
}