package com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunches

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.repository.notes.launches.LaunchesLocalRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoadDBLaunchesUseCaseImpl @Inject constructor(private val repository: LaunchesLocalRepository) : LoadDBLaunchesUseCase {

	private var rocketId: String = ""

	override fun execute(): Observable<List<Launch>> {
		return repository
				.getLaunchesList(rocketId)
				.toObservable()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
	}

	override fun setRocketId(rocketId: String) {
		this.rocketId = rocketId
	}
}