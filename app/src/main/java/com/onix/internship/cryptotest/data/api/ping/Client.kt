package com.onix.internship.cryptotest.data.api.ping

class Client(private val service: Service) {

    suspend fun getResponse() = service.getRequest()
}