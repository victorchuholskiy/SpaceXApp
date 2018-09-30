package com.gmail.victorchuholskiy.spasexapp.ui.launches

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import com.gmail.victorchuholskiy.spasexapp.di.scope.ActivityScope
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunchCounts.LoadDBLaunchCountUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunchCounts.LoadDBLaunchCountUseCaseImpl
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunches.LoadDBLaunchesUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunches.LoadDBLaunchesUseCaseImpl
import com.gmail.victorchuholskiy.spasexapp.usecases.updateLaunches.UpdateLaunchesUseCase
import com.gmail.victorchuholskiy.spasexapp.usecases.updateLaunches.UpdateLaunchesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class LaunchesListActivityModule {

	@Module
	companion object {
		@Provides
		@ActivityScope
		@JvmStatic
		fun provideRocketId(activity: LaunchesListActivity): Bundle = activity.intent.extras?: Bundle()

		@Provides
		@ActivityScope
		@JvmStatic
		fun provideViewModelFactory(extras: Bundle,
									updateLaunchesUseCase: UpdateLaunchesUseCase,
									getLaunchesUseCase: LoadDBLaunchesUseCase,
									getLaunchCountUseCase: LoadDBLaunchCountUseCase)
				= LaunchesListViewModel.Factory(LaunchesListViewModel(extras, updateLaunchesUseCase, getLaunchesUseCase, getLaunchCountUseCase)) as ViewModelProvider.Factory
	}

	@Binds
	@ActivityScope
	abstract fun provideUpdateLaunchesListUseCase(useCase: UpdateLaunchesUseCaseImpl): UpdateLaunchesUseCase

	@Binds
	@ActivityScope
	abstract fun provideGetDBLaunchesListUseCase(useCase: LoadDBLaunchesUseCaseImpl): LoadDBLaunchesUseCase

	@Binds
	@ActivityScope
	abstract fun provideGetDBLaunchCountUseCase(useCase: LoadDBLaunchCountUseCaseImpl): LoadDBLaunchCountUseCase
}