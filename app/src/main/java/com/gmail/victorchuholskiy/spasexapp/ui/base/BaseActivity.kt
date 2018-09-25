package com.gmail.victorchuholskiy.spasexapp.ui.base

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.MenuItem
import com.gmail.victorchuholskiy.spasexapp.BR
import com.gmail.victorchuholskiy.spasexapp.utils.extensions.toast
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<VM : BaseViewModel, B : ViewDataBinding> : DaggerAppCompatActivity() {

	protected lateinit var viewModel: VM
	protected lateinit var binding: B

	/* abstract */

	@LayoutRes
	abstract fun getLayoutRes(): Int

	abstract fun getViewModelClass(): Class<VM>

	abstract fun getViewModelFactory(): ViewModelProvider.Factory

	/* life */

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewModel = ViewModelProviders.of(this, getViewModelFactory())[getViewModelClass()]

		binding = DataBindingUtil.setContentView(this, getLayoutRes())
		binding.setVariable(BR.viewModel, viewModel)
		binding.setLifecycleOwner(this)
		binding.executePendingBindings()
	}

	override fun onStart() {
		super.onStart()

		viewModel.errorMessage.observe(this, Observer {
			onError(it)
		})
	}

	/* inherited */

	override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
		android.R.id.home -> {
			finish()
			true
		}
		else -> super.onOptionsItemSelected(item)
	}

	/* own methods */

	@Suppress("MemberVisibilityCanBePrivate")
	protected fun onError(msg: String?) {
		toast(msg)
	}
}