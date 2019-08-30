package com.devcamp.devcamp_mobile.module.register

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcamp.devcamp_mobile.common.ShopStatus
import com.devcamp.devcamp_mobile.common.User
import com.devcamp.devcamp_mobile.common.dto.ShopRegistrationDTO
import com.devcamp.devcamp_mobile.service.RegisterTokoService
import com.devcamp.devcamp_mobile.util.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterTokoViewModel : ViewModel() {
    private val registerTokoService = NetworkUtil.getRetrofit().create(RegisterTokoService::class.java)
    private val _user = MutableLiveData<User>()
    val user : LiveData<User>get()  = _user

    @SuppressLint("CheckResult")
    fun registerShop(statusDTO:ShopRegistrationDTO) {
        registerTokoService.registerShop(statusDTO)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { }
            .doOnError {
                Log.d("asd", "asd")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _user.postValue(it)
            }, {})
    }
}
