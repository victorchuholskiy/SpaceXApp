package com.gmail.victorchuholskiy.spasexapp.repository.notes.rockets

import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse
import com.gmail.victorchuholskiy.spasexapp.repository.api.MainApi
import io.reactivex.Single
import javax.inject.Inject

class RocketsRemoteRepositoryImpl @Inject constructor(private val mainApi: MainApi) : RocketsRemoteRepository {

	override fun loadRocketsList(): Single<List<RocketResponse>> = mainApi.loadRocketsList()
}