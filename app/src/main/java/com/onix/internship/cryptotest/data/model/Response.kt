package com.onix.internship.cryptotest.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Response(

	@field:SerializedName("gecko_says")
	val geckoSays: String? = null
)
