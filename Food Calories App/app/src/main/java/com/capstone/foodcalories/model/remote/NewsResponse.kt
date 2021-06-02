package com.capstone.foodcalories.model.remote

import com.google.gson.annotations.SerializedName

data class NewsResponse(

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("messages")
	val messages: String,

	@field:SerializedName("status")
	val status: String
)

data class DataItem(

	@field:SerializedName("image")
	val image: Image,

	@field:SerializedName("link")
	val link: String,

	@field:SerializedName("isoDate")
	val isoDate: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("contentSnippet")
	val contentSnippet: String
)

data class Image(

	@field:SerializedName("small")
	val small: String,

	@field:SerializedName("large")
	val large: String
)
