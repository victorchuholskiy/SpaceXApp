package com.gmail.victorchuholskiy.spasexapp.di.module

import com.gmail.victorchuholskiy.spasexapp.repository.notes.launches.LaunchesLocalRepository
import com.gmail.victorchuholskiy.spasexapp.repository.notes.launches.LaunchesLocalRepositoryImpl
import com.gmail.victorchuholskiy.spasexapp.repository.notes.launches.LaunchesRemoteRepository
import com.gmail.victorchuholskiy.spasexapp.repository.notes.launches.LaunchesRemoteRepositoryImpl
import com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets.RocketsLocalRepository
import com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets.RocketsLocalRepositoryImpl
import com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets.RocketsRemoteRepository
import com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets.RocketsRemoteRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

	@Binds
	abstract fun bindRocketsRemoteRepository(repository: RocketsRemoteRepositoryImpl): RocketsRemoteRepository

	@Binds
	abstract fun bindRocketsLocalRepository(repository: RocketsLocalRepositoryImpl): RocketsLocalRepository

	@Binds
	abstract fun bindLaunchesRemoteRepository(repository: LaunchesRemoteRepositoryImpl): LaunchesRemoteRepository

	@Binds
	abstract fun bindLaunchesLocalRepository(repository: LaunchesLocalRepositoryImpl): LaunchesLocalRepository
}