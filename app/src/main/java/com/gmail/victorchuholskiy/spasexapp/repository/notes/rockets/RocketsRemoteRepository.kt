package com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets

import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse
import io.reactivex.Single

interface RocketsRemoteRepository {

	fun loadRocketsList(): Single<List<RocketResponse>>
}