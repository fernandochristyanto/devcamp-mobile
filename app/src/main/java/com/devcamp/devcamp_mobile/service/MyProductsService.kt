package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface MyProductsService{
    @POST("/shop/{id}/products")
    fun getMyProducts(@Path("id") id: Int): Single<GarageSaleProduct>
}