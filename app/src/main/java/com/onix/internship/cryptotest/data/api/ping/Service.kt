package com.onix.internship.cryptotest.data.api.ping

import com.onix.internship.cryptotest.data.model.Response
import retrofit2.http.GET

interface Service {
    @GET("ping")
    suspend fun getRequest(): Response
}