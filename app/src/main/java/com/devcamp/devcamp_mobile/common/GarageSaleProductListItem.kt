package com.devcamp.devcamp_mobile.common

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.google.gson.annotations.SerializedName


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class GarageSaleProductListItem(
    @SerializedName("id") var id: Int,
    @SerializedName("shop_id") var shopId: Int,
    @SerializedName("catalog_id") var catalogId: Int,
    @SerializedName("shop_name") var shopName: String,
    @SerializedName("name") var name: String,
    @SerializedName("price") var price: Int,
    @SerializedName("description") var description: String,
    @SerializedName("stock") var stock: Int,
    @SerializedName("charity") var charity: Boolean,
    @SerializedName("curated") var curated: Boolean,
    @SerializedName("image_url") var imageUrl: String
)