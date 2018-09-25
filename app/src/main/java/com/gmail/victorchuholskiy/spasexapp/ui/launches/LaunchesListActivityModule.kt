package com.gmail.victorchuholskiy.spasexapp.ui.launches

import android.arch.lifecycle.ViewModelProvider
import com.gmail.victorchuholskiy.spasexapp.di.scope.ActivityScope
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
		fun provideRocketId(activity: LaunchesListActivity): String {
			if (activity.intent.extras == null) return ""
			val str = activity.intent.extras!!.getString(LaunchesListActivity.ROCKET_ID_PARAM)
			return if (str.isNullOrEmpty()) "" else str!!
		}

		@Provides
		@ActivityScope
		@JvmStatic
		fun provideViewModelFactory(rocketId: String,
									updateLaunchesUseCase: UpdateLaunchesUseCase,
									getLaunchesUseCase: LoadDBLaunchesUseCase) = LaunchesListViewModel.Factory(LaunchesListViewModel(rocketId, updateLaunchesUseCase, getLaunchesUseCase)) as ViewModelProvider.Factory
	}

	@Binds
	@ActivityScope
	abstract fun provideUpdateLaunchesListUseCase(useCase: UpdateLaunchesUseCaseImpl): UpdateLaunchesUseCase

	@Binds
	@ActivityScope
	abstract fun provideGetDBLaunchesListUseCase(useCase: LoadDBLaunchesUseCaseImpl): LoadDBLaunchesUseCase
}