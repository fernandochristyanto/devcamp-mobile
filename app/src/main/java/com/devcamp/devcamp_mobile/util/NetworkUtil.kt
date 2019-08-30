package com.devcamp.devcamp_mobile.util

import com.devcamp.devcamp_mobile.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtil {
    companion object{
        private var retrofit: Retrofit? = null

        fun getRetrofit(): Retrofit {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}