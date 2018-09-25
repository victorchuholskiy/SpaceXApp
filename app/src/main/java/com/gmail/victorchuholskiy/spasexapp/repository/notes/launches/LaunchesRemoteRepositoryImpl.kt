package com.gmail.victorchuholskiy.spasexapp.repository.notes.launches

import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.LaunchResponse
import com.gmail.victorchuholskiy.spasexapp.repository.api.MainApi
import io.reactivex.Single
import java.util.HashMap
import javax.inject.Inject

class LaunchesRemoteRepositoryImpl @Inject constructor(private val mainApi: MainApi) : LaunchesRemoteRepository {

	override fun loadLaunchesList(id: String): Single<List<LaunchResponse>> = mainApi.loadRocketDetails(id)
}