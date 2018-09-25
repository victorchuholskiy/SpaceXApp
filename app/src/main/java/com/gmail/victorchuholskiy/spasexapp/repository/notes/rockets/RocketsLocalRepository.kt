package com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import io.reactivex.Flowable

interface RocketsLocalRepository {
	fun getRocketsList(): Flowable<List<Rocket>>
}