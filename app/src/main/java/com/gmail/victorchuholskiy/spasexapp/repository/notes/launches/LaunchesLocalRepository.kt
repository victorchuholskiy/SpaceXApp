package com.gmail.victorchuholskiy.spasexapp.repository.notes.launches

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.query.LaunchStatistic
import io.reactivex.Flowable

interface LaunchesLocalRepository {
	fun getLaunchesList(rocketId: String): Flowable<List<Launch>>

	fun getLaunchStatistic(rocketId: String): Flowable<List<LaunchStatistic>>
}