package com.gmail.victorchuholskiy.spasexapp.usecases.loadDBRockets

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.usecases.UseCase
import io.reactivex.Observable

interface LoadDBRocketsUseCase: UseCase<List<Rocket>> {
	override fun execute(): Observable<List<Rocket>>
}