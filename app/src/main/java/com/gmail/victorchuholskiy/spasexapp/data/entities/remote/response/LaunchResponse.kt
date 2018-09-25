package com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by user
 * 24.09.2018.
 */
class LaunchResponse {

	@SerializedName("flight_number")
	var flightNumber: Int = 0

	@SerializedName("mission_name")
	var missionName: String ?= null

	@SerializedName("launch_year")
	var launchYear: String ?= ""

	@SerializedName("launch_date_unix")
	var launchDateUnix: Long = 0

	@SerializedName("launch_success")
	var launchSuccess: Boolean = false

	@SerializedName("links")
	var links: Links ?= null

	class Links {
		@SerializedName("mission_patch")
		var missionPatch: String ?= null
	}
}