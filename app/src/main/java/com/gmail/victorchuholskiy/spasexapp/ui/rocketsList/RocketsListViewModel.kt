package com.gmail.victorchuholskiy.spasexapp.ui.rocketsList

import android.arch.lifecycle.MutableLiveData
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.ui.base.BaseViewModel
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBRockets.LoadDBRocketsUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.updateRockets.UpdateRocketsUseCase
import com.gmail.victorchuholskiy.spasexapp.utils.ViewModelProviderFactory
import com.gmail.victorchuholskiy.spasexapp.utils.extensions.applySchedulers
import io.reactivex.Observable

class RocketsListViewModel(private val updateRocketUseCase: UpdateRocketsUseCase,
						   private val getRocketsUseCase: LoadDBRocketsUseCase) : BaseViewModel() {

	val rocketsList = MutableLiveData<List<Rocket>>()

	init {
		updateRocketList()
	}

	private fun updateRocketList() {
		isLoading.value = true
		disposables.add(
				updateRocketUseCase.execute()
						.applySchedulers()
						.onErrorResumeNext{ throwable: Throwable ->
							errorMessage.value = throwable.toString()
							Observable.just(false)
						}
						.flatMap { getRocketsUseCase.execute() }
						.subscribe(
								{
									isLoading.value = false
									rocketsList.value = it
								},
								{
									isLoading.value = false
									errorMessage.value = it.toString()
								}
						))
	}

	/* data types */

	class Factory(viewModel: RocketsListViewModel) : ViewModelProviderFactory<RocketsListViewModel>(viewModel)
}