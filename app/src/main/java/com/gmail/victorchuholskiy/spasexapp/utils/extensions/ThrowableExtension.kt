package com.gmail.victorchuholskiy.spasexapp.utils.extensions

import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.SimpleErrorResponse
import com.gmail.victorchuholskiy.spasexapp.repository.api.error.RetrofitException

fun Throwable.processError(): String? = when (this) {
	is RetrofitException -> when (kind) {
		RetrofitException.Kind.HTTP -> try {
			getErrorBodyAs(SimpleErrorResponse::class.java)?.msg
		} catch (e: Exception) {
			e.toString()
		}
		RetrofitException.Kind.NETWORK -> "No internet connection"
		RetrofitException.Kind.UNEXPECTED -> "UNEXPECTED error"
	}
	else -> "Not Retrofit error: ${toString()}"
}