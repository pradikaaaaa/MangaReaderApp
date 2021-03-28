package com.example.mangareader.utils

import com.example.mangareader.models.Chapter
import com.example.mangareader.models.Genre
import com.google.gson.annotations.SerializedName

data class MangaListResponse<T>(
    @SerializedName("status") var status : Boolean? = null,
    @SerializedName("message") var message : String? = null,
    @SerializedName("manga_list") var manga_list : List<T>? = null
)

data class DetailMangaResponse(

    @field:SerializedName("genre_list")
    val genreList: List<Genre?>? = null,

    @field:SerializedName("chapter")
    val chapter: List<Chapter?>? = null,

    @field:SerializedName("thumb")
    val thumb: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("synopsis")
    val synopsis: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("manga_endpoint")
    val mangaEndpoint: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)