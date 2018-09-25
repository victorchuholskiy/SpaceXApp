package com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by user
 * 24.09.2018.
 */
class RocketResponse {

	@SerializedName("id")
	var id: Int = 0

	@SerializedName("active")
	var active: Boolean = false

	@SerializedName("stages")
	var stages: Int = 1

	@SerializedName("boosters")
	var boosters: Int = 1

	@SerializedName("cost_per_launch")
	var costPerLaunch: Long = 0

	@SerializedName("first_flight")
	var firstFlight: String ?= null

	@SerializedName("country")
	var country: String ?= null

	@SerializedName("company")
	var company: String ?= null

	@SerializedName("rocket_id")
	var rocketId: String ?= null

	@SerializedName("rocket_name")
	var rocketName: String ?= null

	@SerializedName("engines")
	var engines: Engine? = null

	@SerializedName("details")
	var details: String ?= null

	class Engine {
		@SerializedName("number")
		var number: Int = 0
	}
}