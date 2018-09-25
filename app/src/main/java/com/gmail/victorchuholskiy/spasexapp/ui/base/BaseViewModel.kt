package com.gmail.victorchuholskiy.spasexapp.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.gmail.victorchuholskiy.spasexapp.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by aleksey.stepanov
 * 8/9/18.
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