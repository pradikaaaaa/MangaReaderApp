package com.example.mangareader.models

import com.google.gson.annotations.SerializedName

data class Manga(

	@field:SerializedName("updated_on")
	val updatedOn: String? = null,

	@field:SerializedName("chapter")
	val chapter: String? = null,

	@field:SerializedName("endpoint")
	val endpoint: String? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)
