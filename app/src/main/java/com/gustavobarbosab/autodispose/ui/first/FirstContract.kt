package com.gustavobarbosab.autodispose.ui.first

import com.gustavobarbosab.autodispose.autocleared.ViewObservable

interface FirstContract {

    interface View : ViewObservable {
        fun showInitToast()
        fun showDestroyToast()
    }

    interface Presenter {
        fun init()
    }
}