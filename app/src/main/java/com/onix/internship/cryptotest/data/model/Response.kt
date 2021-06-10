package com.onix.internship.cryptotest.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(

	@SerialName("gecko_says")
	val geckoSays: String = ""
)
