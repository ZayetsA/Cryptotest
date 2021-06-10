package com.onix.internship.cryptotest.data.api.ping

class Helper(private val service: Service) {

    suspend fun getResponse() = service.getRequest()
}