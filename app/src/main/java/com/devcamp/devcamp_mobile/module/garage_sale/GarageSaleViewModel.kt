package com.devcamp.devcamp_mobile.module.garage_sale

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.common.GarageSaleProductListItem
import com.devcamp.devcamp_mobile.service.GarageSaleService
import com.devcamp.devcamp_mobile.util.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GarageSaleViewModel: ViewModel() {
    private val garageSaleService = NetworkUtil.getRetrofit().create(GarageSaleService::class.java)

    private val _garageSaleProduct = MutableLiveData<List<GarageSaleProductListItem>>()
    val garageSaleProduct: LiveData<List<GarageSaleProductListItem>>
        get() = _garageSaleProduct

    @SuppressLint("CheckResult")
    fun getAllGarageSaleProducts(){
        garageSaleService.getAllGarageSaleProducts()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {  }
            .doOnError {
                Log.d("asd", "asd")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _garageSaleProduct.postValue(it)
            }, {})


    }
}