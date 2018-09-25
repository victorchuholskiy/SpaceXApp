package com.gmail.victorchuholskiy.spasexapp.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.gmail.victorchuholskiy.spasexapp.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by victor.chukholskiy
 * 25.09.2018.
 */
abstract class BaseViewModel : ViewModel() {

	protected val disposables = CompositeDisposable()

	val isLoading = MutableLiveData<Boolean>()
	val errorMessage = SingleLiveEvent<String?>()

	override fun onCleared() {
		disposables.clear()
		super.onCleared()
	}
}