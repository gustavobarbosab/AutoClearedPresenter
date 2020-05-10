package com.gustavobarbosab.autodispose.autocleared

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

open class AutoClearedPresenter<VIEW : ViewObservable>(
    var view: VIEW? = null
) : LifecycleObserver {

    init {
        observeViewLifecycle()
    }

    private fun observeViewLifecycle() {
        view?.lifecycle?.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onCleared() {
        view?.lifecycle?.removeObserver(this)
        view = null
    }
}