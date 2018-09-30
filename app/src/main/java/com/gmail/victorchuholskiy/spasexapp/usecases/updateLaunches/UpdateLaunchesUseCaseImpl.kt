package com.gmail.victorchuholskiy.spasexapp.usecases.updateLaunches

import android.content.Context
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.mappers.SpaceXMapperImpl
import com.gmail.victorchuholskiy.spasexapp.repository.db.SpaceXDataBase
import com.gmail.victorchuholskiy.spasexapp.repository.notes.launches.LaunchesRemoteRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UpdateLaunchesUseCaseImpl @Inject constructor(private val context: Context,
													private val repository: LaunchesRemoteRepository) : UpdateLaunchesUseCase {

	private var rocketId: String = ""

	override fun execute(): Observable<Boolean> {
		return repository
				.loadLaunchesList(rocketId)
				.map {
					if (it.isNotEmpty()) {
						val db = SpaceXDataBase.getInstance(context)
						val list = ArrayList<Launch>()
						for (response in it) {
							list.add(SpaceXMapperImpl.map(response, rocketId))
						}
						db.launchesDao().deleteProducts()
						db.launchesDao().insertAll(list)
						true
					} else {
						false
					}
				}
				.toObservable()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
	}

	override fun setRocketId(rocketId: String) {
		this.rocketId = rocketId
	}
}