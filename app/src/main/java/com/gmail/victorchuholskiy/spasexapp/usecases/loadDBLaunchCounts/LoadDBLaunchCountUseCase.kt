package com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunchCounts

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.query.LaunchStatistic
import com.gmail.victorchuholskiy.spasexapp.usecases.UseCase
import io.reactivex.Observable

interface LoadDBLaunchCountUseCase: UseCase<List<LaunchStatistic>> {
	override fun execute(): Observable<List<LaunchStatistic>>

	fun setRocketId(rocketId: String)
}