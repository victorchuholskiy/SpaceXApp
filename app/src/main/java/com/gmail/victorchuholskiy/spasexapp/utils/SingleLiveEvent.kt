package com.gmail.victorchuholskiy.spasexapp.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import android.util.Log
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by user
 * 25.09.2018.
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

	private val pending = AtomicBoolean(false)

	companion object {
		private const val TAG = "SingleLiveEvent"
	}

	@MainThread
	override fun observe(owner: LifecycleOwner,
						 observer: Observer<T>) {

		if (hasActiveObservers()) {
			Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
		}

		// Observe the internal MutableLiveData
		super.observe(owner, Observer { t ->
			if (pending.compareAndSet(true, false)) {
				observer.onChanged(t)
			}
		})
	}

	@MainThread
	override fun setValue(t: T?) {
		pending.set(true)
		super.setValue(t)
	}

	/**
	 * Used for cases where T is Void, to make calls cleaner.
	 */
	@MainThread
	fun call() {
		value = null
	}
}