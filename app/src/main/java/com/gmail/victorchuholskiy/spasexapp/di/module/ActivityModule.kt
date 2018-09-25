package com.gmail.victorchuholskiy.spasexapp.di.module

import com.gmail.victorchuholskiy.spasexapp.di.scope.ActivityScope
import com.gmail.victorchuholskiy.spasexapp.ui.rocketsList.RocketsListActivity
import com.gmail.victorchuholskiy.spasexapp.ui.rocketsList.RocketsListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

	@ActivityScope
	@ContributesAndroidInjector(modules = [RocketsListActivityModule::class])
	abstract fun rocketsActivity(): RocketsListActivity

}