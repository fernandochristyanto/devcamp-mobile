package com.devcamp.devcamp_mobile.module.my_products

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.service.MyProductsService
import com.devcamp.devcamp_mobile.util.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyProductsViewModel: ViewModel() {
    private val myProductsService = NetworkUtil.getRetrofit().create(MyProductsService::class.java)
    private val _myProducts = MutableLiveData<GarageSaleProduct>()
    val myProducts: LiveData<GarageSaleProduct>
        get() = _myProducts

    @SuppressLint("CheckResult")
    fun getMyProducts(id: Int){
        myProductsService.getMyProducts(id)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {  }
            .doOnError {
                Log.d("asd", "asd")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _myProducts.postValue(it)
            }, {})
    }
}