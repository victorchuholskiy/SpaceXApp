package com.gmail.victorchuholskiy.spasexapp.repository.notes.launches

import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.LaunchResponse
import io.reactivex.Single

interface LaunchesRemoteRepository {

	fun loadLaunchesList(id: String): Single<List<LaunchResponse>>
}