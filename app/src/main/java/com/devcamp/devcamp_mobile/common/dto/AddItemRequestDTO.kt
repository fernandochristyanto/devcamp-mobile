package com.devcamp.devcamp_mobile.common.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.google.gson.annotations.SerializedName

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class AddItemRequestDTO(
    @SerializedName("shop_id") var shopID: Int,
    @SerializedName("catalog_id") var catalogID: Int,
    @SerializedName("name") var name: String,
    @SerializedName("price") var price: Int,
    @SerializedName("description") var description: String,
    @SerializedName("stock") var stock: Int,
    @SerializedName("charity") var charity: Boolean
)