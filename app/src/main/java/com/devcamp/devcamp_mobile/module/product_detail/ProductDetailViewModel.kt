package com.devcamp.devcamp_mobile.module.product_detail

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.service.ProductService
import com.devcamp.devcamp_mobile.util.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProductDetailViewModel : ViewModel() {
    val productService = NetworkUtil.getRetrofit().create(ProductService::class.java)

    private val _garageProduct = MutableLiveData<GarageSaleProduct>()
    val garageProduct: LiveData<GarageSaleProduct>
        get() = _garageProduct

    @SuppressLint("CheckResult")
    fun getProductById(id: Int){
        productService.getProductById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {  }
            .doOnEvent { t1, t2 ->  }
            .subscribe({
                _garageProduct.postValue(it)
            }, {})
    }
}