package com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by victor.chukholskiy
 * 25.09.2018.
 */
data class SimpleErrorResponse(
		@SerializedName("status") val status: String,
		@SerializedName("message") val msg: String?
)