package com.gustavobarbosab.autodispose.second

import com.gustavobarbosab.autodispose.BaseView

interface SecondContract {

    interface View : BaseView {
        fun showDestroyToast()
        fun showSuccess()
        fun showError()
    }

    interface Presenter {
        fun getNamesFromService()
    }
}