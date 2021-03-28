package com.example.mangareader.models

import com.google.gson.annotations.SerializedName

data class Chapter(
    @field:SerializedName("chapter_endpoint")
    val chapterEndpoint: String? = null,

    @field:SerializedName("chapter_title")
    val chapterTitle: String? = null
)