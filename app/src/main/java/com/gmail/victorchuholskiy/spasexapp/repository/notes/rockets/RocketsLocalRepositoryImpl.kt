package com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets

import android.content.Context
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.repository.db.SpaceXDataBase
import io.reactivex.Flowable
import javax.inject.Inject

class RocketsLocalRepositoryImpl @Inject constructor(private val context: Context) : RocketsLocalRepository {

	override fun getRocketsList(): Flowable<List<Rocket>> {
		return SpaceXDataBase.getInstance(context)!!
				.productsDao()
				.getAll()
	}


}