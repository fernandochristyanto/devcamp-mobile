package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.ShopStatus
import com.devcamp.devcamp_mobile.common.User
import com.devcamp.devcamp_mobile.common.dto.ShopRegistrationDTO
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RegisterTokoService {
    @POST("/users/shopregistration")
    fun registerShop(@Body statusDTO:ShopRegistrationDTO): Single<User>
}