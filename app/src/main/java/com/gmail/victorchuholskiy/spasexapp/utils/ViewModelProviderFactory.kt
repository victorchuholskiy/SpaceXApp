package com.gmail.victorchuholskiy.spasexapp.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by user
 * 25.09.2018.
 */
open class ViewModelProviderFactory<VM : Any>(private val viewModel: VM) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(viewModel::class.java)) {
			@Suppress("UNCHECKED_CAST")
			return viewModel as T
		}
		throw IllegalArgumentException("Wrong class name")
	}
}