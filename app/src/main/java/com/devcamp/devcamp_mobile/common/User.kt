package com.devcamp.devcamp_mobile.common

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.google.gson.annotations.SerializedName

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class User(
    @SerializedName("id") var id: Int,
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String?
)