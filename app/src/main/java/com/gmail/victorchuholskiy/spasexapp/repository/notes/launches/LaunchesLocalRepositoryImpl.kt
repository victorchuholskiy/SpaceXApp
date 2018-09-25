package com.gmail.victorchuholskiy.spasexapp.repository.notes.launches

import android.content.Context
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.repository.db.SpaceXDataBase
import io.reactivex.Flowable
import javax.inject.Inject

class LaunchesLocalRepositoryImpl @Inject constructor(private val context: Context) : LaunchesLocalRepository {

	override fun getLaunchesList(rocketId: String): Flowable<List<Launch>> {
		return SpaceXDataBase.getInstance(context)!!
				.launchesDao()
				.getAllByRocketId(rocketId)
	}
}