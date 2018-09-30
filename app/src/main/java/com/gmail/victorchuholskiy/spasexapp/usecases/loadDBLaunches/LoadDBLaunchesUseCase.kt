package com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunches

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.usecases.UseCase
import io.reactivex.Observable

interface LoadDBLaunchesUseCase: UseCase<List<Launch>> {
	override fun execute(): Observable<List<Launch>>

	fun setRocketId(rocketId: String)
}