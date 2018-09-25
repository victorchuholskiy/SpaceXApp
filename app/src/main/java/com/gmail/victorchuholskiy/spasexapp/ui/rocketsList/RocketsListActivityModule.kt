package com.gmail.victorchuholskiy.spasexapp.ui.rocketsList

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.gmail.victorchuholskiy.spasexapp.di.scope.ActivityScope
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBRockets.LoadDBRocketsUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBRockets.LoadDBRocketsUseCaseImpl
import com.gmail.victorchuholskiy.spasexapp.usecases.updateRockets.UpdateRocketsUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.updateRockets.UpdateRocketsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RocketsListActivityModule {

	@Module
	companion object {
		@Provides
		@ActivityScope
		@JvmStatic
		fun provideViewModelFactory(updateRocketUseCase: UpdateRocketsUseCase,
									getRocketsUseCase: LoadDBRocketsUseCase) = RocketsListViewModel.Factory(RocketsListViewModel(updateRocketUseCase, getRocketsUseCase)) as ViewModelProvider.Factory
	}

	@Binds
	@ActivityScope
	abstract fun provideUpdateRocketsListUseCase(useCase: UpdateRocketsUseCaseImpl): UpdateRocketsUseCase

	@Binds
	@ActivityScope
	abstract fun provideGetDBRocketsListUseCase(useCase: LoadDBRocketsUseCaseImpl): LoadDBRocketsUseCase
}