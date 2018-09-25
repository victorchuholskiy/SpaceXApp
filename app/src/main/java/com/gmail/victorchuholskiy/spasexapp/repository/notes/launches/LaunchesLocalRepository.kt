package com.gmail.victorchuholskiy.spasexapp.repository.notes.launches

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import io.reactivex.Flowable

interface LaunchesLocalRepository {
	fun getLaunchesList(rocketId: String): Flowable<List<Launch>>
}