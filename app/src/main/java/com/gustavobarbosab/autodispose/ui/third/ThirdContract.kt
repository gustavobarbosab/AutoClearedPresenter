package com.gustavobarbosab.autodispose.ui.third

import com.gustavobarbosab.autoclearedpresenter.ViewObservable
import com.gustavobarbosab.autodispose.domain.Person

interface ThirdContract {

    interface View : ViewObservable {
        fun showLoading()
        fun hideLoading()
        fun showPeople(people: List<Person>)
        fun showToastDestroyed()
    }

    interface Presenter {
        fun loadPeople()
    }
}