package com.example.mangareader.webservices

import com.example.mangareader.models.Manga
import com.example.mangareader.utils.DetailMangaResponse
import com.example.mangareader.utils.MangaListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("manga/page/{pagenumber}")
    fun allManga(@Path("pagenumber") pagenumber : Int) : Call<MangaListResponse<Manga>>

    @GET("manga/popular/{pagenumber}")
    fun popularManga(@Path("pagenumber") pagenumber: Int) : Call<MangaListResponse<Manga>>

    @GET("recommended")
    fun recommendedManga() : Call<MangaListResponse<Manga>>

    @GET("manhua/{pagenumber}")
    fun allManhua(@Path("pagenumber") pagenumber : Int) : Call<MangaListResponse<Manga>>

    @GET("manhwa/{pagenumber}")
    fun allManhwa(@Path("pagenumber") pagenumber: Int) : Call<MangaListResponse<Manga>>

    @GET("manga/detail/{endpoint}")
    fun detailManga(@Path("endpoint") endpoint: String) : Call<DetailMangaResponse>
}