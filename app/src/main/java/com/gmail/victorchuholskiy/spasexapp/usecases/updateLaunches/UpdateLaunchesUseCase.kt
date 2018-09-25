package com.gmail.victorchuholskiy.spasexapp.usecases.updateLaunches

import com.gmail.victorchuholskiy.spasexapp.usecases.UseCase
import io.reactivex.Observable

interface UpdateLaunchesUseCase: UseCase<Boolean> {
	override fun execute(): Observable<Boolean>

	fun setRocketId(rocketId: String)
}