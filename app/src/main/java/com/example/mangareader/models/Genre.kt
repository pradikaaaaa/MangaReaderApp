package com.example.mangareader.models

import com.google.gson.annotations.SerializedName

data class Genre(
    @field:SerializedName("genre_name")
    val genreName: String? = null
)