package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.User
import com.devcamp.devcamp_mobile.common.dto.UserLoginRequestDTO
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService{
    @POST("/users")
    fun getUserByEmailAndPassword(): Single<User>

//    @POST("/users/login")
//    fun login(@Body userDTO:UserLoginRequestDTO): Single<User>
}