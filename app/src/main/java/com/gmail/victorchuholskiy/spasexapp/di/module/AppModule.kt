package com.gmail.victorchuholskiy.spasexapp.di.module

import android.app.Application
import android.content.Context
import com.gmail.victorchuholskiy.spasexapp.App
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
	@Binds
	internal abstract fun bindContext(application: Application): Context

	@Binds
	internal abstract fun bindApplication(application: App): Application
}
