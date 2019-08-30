package com.devcamp.devcamp_mobile.data

import com.devcamp.devcamp_mobile.common.User

class UserSession {
    companion object {
        private var user: User? = null

        fun setUser(loginUser: User){
            user = loginUser
        }

        fun getUser(): User? = user
    }
}