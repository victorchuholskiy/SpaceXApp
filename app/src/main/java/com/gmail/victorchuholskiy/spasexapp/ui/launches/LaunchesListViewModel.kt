package com.gmail.victorchuholskiy.spasexapp.ui.launches

import android.arch.lifecycle.MutableLiveData
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.ui.base.BaseViewModel
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunches.LoadDBLaunchesUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.updateLaunches.UpdateLaunchesUseCase
import com.gmail.victorchuholskiy.spasexapp.utils.ViewModelProviderFactory
import com.gmail.victorchuholskiy.spasexapp.utils.extensions.applySchedulers
import io.reactivex.Observable

class LaunchesListViewModel(private val rocketId: String,
							private val updateLaunchesUseCase: UpdateLaunchesUseCase,
							private val getLaunchesUseCase: LoadDBLaunchesUseCase) : BaseViewModel() {

	val launchesList = MutableLiveData<List<Launch>>()

	init {
		updateLaunchesList()
	}

	private fun updateLaunchesList() {
		isLoading.value = true
		updateLaunchesUseCase.setRocketId(rocketId)
		getLaunchesUseCase.setRocketId(rocketId)

		disposables.add(
				updateLaunchesUseCase.execute()
						.applySchedulers()
						.onErrorResumeNext{ throwable: Throwable ->
							errorMessage.value = throwable.toString()
							Observable.just(false)
						}
						.flatMap { getLaunchesUseCase.execute() }
						.subscribe(
								{
									isLoading.value = false
									launchesList.value = it
								},
								{
									isLoading.value = false
									errorMessage.value = it.toString()
								}
						))
	}

	/* data types */

	class Factory(viewModel: LaunchesListViewModel) : ViewModelProviderFactory<LaunchesListViewModel>(viewModel)
}