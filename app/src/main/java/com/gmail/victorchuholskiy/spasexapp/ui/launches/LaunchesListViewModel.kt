package com.gmail.victorchuholskiy.spasexapp.ui.launches

import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.query.LaunchStatistic
import com.gmail.victorchuholskiy.spasexapp.ui.base.BaseViewModel
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunchCounts.LoadDBLaunchCountUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunches.LoadDBLaunchesUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.updateLaunches.UpdateLaunchesUseCase
import com.gmail.victorchuholskiy.spasexapp.utils.ViewModelProviderFactory
import com.gmail.victorchuholskiy.spasexapp.utils.extensions.applySchedulers
import io.reactivex.Observable

/**
 * Created by victor.chukholskiy
 * 25.09.2018.
 */
class LaunchesListViewModel(private val extras: Bundle,
							private val updateLaunchesUseCase: UpdateLaunchesUseCase,
							private val getLaunchesUseCase: LoadDBLaunchesUseCase,
							private val getLaunchStatisticUseCase: LoadDBLaunchCountUseCase) : BaseViewModel() {

	val launchesList = MutableLiveData<List<Launch>>()
	val launchStatisticList = MutableLiveData<List<LaunchStatistic>>()
	val details = MutableLiveData<String>()

	init {
		updateLaunchesList()
	}

	private fun updateLaunchesList() {
		isLoading.value = true

		val rocketId = extras.getString(LaunchesListActivity.ROCKET_ID_PARAM, "")
		updateLaunchesUseCase.setRocketId(rocketId)
		getLaunchesUseCase.setRocketId(rocketId)
		getLaunchStatisticUseCase.setRocketId(rocketId)

		details.value = extras.getString(LaunchesListActivity.ROCKET_DESC_PARAM, "")

		disposables.add(
				updateLaunchesUseCase.execute()
						.applySchedulers()
						.onErrorResumeNext{ throwable: Throwable ->
							errorMessage.value = throwable.toString()
							Observable.just(false)
						}
						.flatMap { getLaunchStatisticUseCase.execute() }
						.flatMap {
							launchStatisticList.value = it
							getLaunchesUseCase.execute()
						}
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