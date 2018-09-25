package com.gmail.victorchuholskiy.spasexapp

import com.gmail.victorchuholskiy.spasexapp.di.DaggerAppComponent
import com.gmail.victorchuholskiy.spasexapp.repository.db.SpaceXDataBase
import dagger.android.DaggerApplication

/**
 * Created by user
 * 25.09.2018.
 */
class App : DaggerApplication() {
	override fun onCreate() {
		super.onCreate()
		SpaceXDataBase.getInstance(this)
	}

	override fun applicationInjector() = DaggerAppComponent.builder().app(this).build()
}