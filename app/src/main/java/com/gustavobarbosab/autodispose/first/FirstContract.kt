package com.gustavobarbosab.autodispose.first

import com.gustavobarbosab.autodispose.BaseView

interface FirstContract {

    interface View : BaseView {
        fun showInitToast()
        fun showDestroyToast()
    }

    interface Presenter {
        fun init()
    }
}