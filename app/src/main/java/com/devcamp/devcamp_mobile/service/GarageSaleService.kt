package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface GarageSaleService{
    @POST("/products/garageSale")
    fun getAllGarageSaleProducts(): Single<GarageSaleProduct>

}