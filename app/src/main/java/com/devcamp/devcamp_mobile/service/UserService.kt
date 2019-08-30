package com.devcamp.devcamp_mobile.service

import com.devcamp.devcamp_mobile.common.User
import io.reactivex.Single

interface UserService{
    fun getUserByEmailAndPassword(email: String, password: String): Single<User>
}