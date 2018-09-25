package com.gmail.victorchuholskiy.spasexapp.usecases.updateRockets

import com.gmail.victorchuholskiy.spasexapp.usecases.UseCase
import io.reactivex.Observable

interface UpdateRocketsUseCase: UseCase<Boolean> {
	override fun execute(): Observable<Boolean>
}