package com.gmail.victorchuholskiy.spasexapp.utils.extensions

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T : Any?> ObservableEmitter<T>.handleError(throwable: Throwable) {
	if (!isDisposed) {
		onError(throwable)
	}
}

fun <T> Observable<T>.applySchedulers(scheduler: Scheduler = Schedulers.io()): Observable<T> = subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())
fun <T> Single<T>.applySchedulers(scheduler: Scheduler = Schedulers.io()): Single<T> = subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())
