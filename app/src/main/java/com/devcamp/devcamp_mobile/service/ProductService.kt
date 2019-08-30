package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService{
    @GET("/products/detail/{id}")
    fun getProductById(@Path("id") id: Int): Single<GarageSaleProduct>
}