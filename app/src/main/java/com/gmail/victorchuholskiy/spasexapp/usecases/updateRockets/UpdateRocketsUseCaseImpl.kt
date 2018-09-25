package com.gmail.victorchuholskiy.spasexapp.usecases.updateRockets

import android.content.Context
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.data.mappers.SpaceXMapperImpl
import com.gmail.victorchuholskiy.spasexapp.repository.db.SpaceXDataBase
import com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets.RocketsRemoteRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UpdateRocketsUseCaseImpl @Inject constructor(private val context: Context,
												   private val repository: RocketsRemoteRepository) : UpdateRocketsUseCase {
	override fun execute(): Observable<Boolean> {
		return repository
				.loadRocketsList()
				.map {
					if (it.isNotEmpty()) {
						val db = SpaceXDataBase.getInstance(context)
						val list = ArrayList<Rocket>()
						for (response in it) {
							list.add(SpaceXMapperImpl.map(response))
						}
						db!!.productsDao().deleteProducts()
						db.productsDao().insertAll(list)
						true
					} else {
						false
					}
				}
				.toObservable()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
	}
}