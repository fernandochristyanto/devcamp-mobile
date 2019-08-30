package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService{
    @POST("/users")
    fun getUserByEmailAndPassword(): Single<User>
}