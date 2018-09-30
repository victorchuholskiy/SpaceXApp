package com.gmail.victorchuholskiy.spasexapp.usecases.loadDBLaunchCounts

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.query.LaunchStatistic
import com.gmail.victorchuholskiy.spasexapp.repository.notes.launches.LaunchesLocalRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoadDBLaunchCountUseCaseImpl @Inject constructor(private val repository: LaunchesLocalRepository) : LoadDBLaunchCountUseCase {

	private var rocketId: String = ""

	override fun execute(): Observable<List<LaunchStatistic>> {
		return repository
				.getLaunchStatistic(rocketId)
				.toObservable()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
	}

	override fun setRocketId(rocketId: String) {
		this.rocketId = rocketId
	}
}