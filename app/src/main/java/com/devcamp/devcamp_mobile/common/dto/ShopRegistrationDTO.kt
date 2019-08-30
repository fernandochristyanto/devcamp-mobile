package com.devcamp.devcamp_mobile.common.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.google.gson.annotations.SerializedName


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

data class ShopRegistrationDTO (
    @SerializedName("name") var name: String,
    @SerializedName("location") var location: String,
    @SerializedName("phone_number") var phone_number: String,
    @SerializedName("email") var email: String?,
    @SerializedName("password") var password: String?,
    @SerializedName("user_id") var user_id: String?

)

