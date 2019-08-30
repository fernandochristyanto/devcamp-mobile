package com.devcamp.devcamp_mobile.module.login

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcamp.devcamp_mobile.common.User
import com.devcamp.devcamp_mobile.service.UserService
import com.devcamp.devcamp_mobile.util.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginViewModel: ViewModel() {
    private val userService = NetworkUtil.getRetrofit().create(UserService::class.java)
    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    @SuppressLint("CheckResult")
    fun getUserByEmailAndPassword(email: String, password: String){
        userService.getUserByEmailAndPassword(email, password)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {  }
            .doOnError {  }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _user.postValue(it)
            }, {})
    }
}