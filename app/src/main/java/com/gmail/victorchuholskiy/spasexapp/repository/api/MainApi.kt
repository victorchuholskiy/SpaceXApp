package com.gmail.victorchuholskiy.spasexapp.repository.api

import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by victor
 * 23.09.18.
 */
interface MainApi {

	@GET("/v3/rockets")
	fun loadRocketsList(): Single<List<RocketResponse>>

	@GET("/v3/rockets/{id}")
	fun loadRocketDetails(@Path("id") id: String): Single<RocketResponse>
}