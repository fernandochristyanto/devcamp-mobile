package com.devcamp.devcamp_mobile.module.add_item

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcamp.devcamp_mobile.common.GarageSaleProduct
import com.devcamp.devcamp_mobile.common.dto.AddItemRequestDTO
import com.devcamp.devcamp_mobile.service.GarageSaleService
import com.devcamp.devcamp_mobile.util.NetworkUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddItemViewModel: ViewModel() {
    private val garageSaleService = NetworkUtil.getRetrofit().create(GarageSaleService::class.java)

    private val _garageSaleProduct = MutableLiveData<GarageSaleProduct>()
    val garageSaleProduct: LiveData<GarageSaleProduct>
        get() = _garageSaleProduct

    @SuppressLint("CheckResult")
    fun addNewItems(itemDTO: AddItemRequestDTO){
        garageSaleService.addNewItems(itemDTO)
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