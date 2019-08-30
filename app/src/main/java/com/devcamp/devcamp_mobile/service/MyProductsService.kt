package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.common.GarageSaleProductListItem
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MyProductsService{
    @GET("/users/{id}/products")
    fun getMyProducts(@Path("id") id: Int): Single<List<GarageSaleProductListItem>>
}