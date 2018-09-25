package com.gmail.victorchuholskiy.spasexapp.usecases.loadDBRockets

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets.RocketsLocalRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoadDBRocketsUseCaseImpl @Inject constructor(private val repository: RocketsLocalRepository) : LoadDBRocketsUseCase {
	override fun execute(): Observable<List<Rocket>> {
		return repository
				.getRocketsList()
				.toObservable()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
	}
}