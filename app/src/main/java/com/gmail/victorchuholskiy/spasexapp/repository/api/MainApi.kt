package com.gmail.victorchuholskiy.spasexapp.repository.api

import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.LaunchResponse
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by victor
 * 23.09.18.
 */
interface MainApi {

	@GET("/v3/rockets")
	fun loadRocketsList(): Single<List<RocketResponse>>

	@GET("/v3/launches")
	fun loadRocketDetails(@Query("rocket_id") rocketId: String): Single<List<LaunchResponse>>
}