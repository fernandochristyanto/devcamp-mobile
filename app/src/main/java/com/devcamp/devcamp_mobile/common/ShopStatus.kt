package com.devcamp.devcamp_mobile.common

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.google.gson.annotations.SerializedName


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class ShopStatus (
    @SerializedName("message") var status : String
)