package com.devcamp.devcamp_mobile.common.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.google.gson.annotations.SerializedName

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class UserLoginRequestDTO(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String?
)