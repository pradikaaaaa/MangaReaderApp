package com.example.mangareader.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mangareader.models.Manga
import com.example.mangareader.utils.Constans
import com.example.mangareader.utils.DetailMangaResponse
import com.example.mangareader.utils.MangaListResponse
import com.example.mangareader.utils.SingleLiveEvent
import com.example.mangareader.webservices.ApiClient
import retrofit2.Call
import retrofit2.Response

class MangaViewModel : ViewModel(){
    private var mangas = MutableLiveData<List<Manga>>()
    private var manga = MutableLiveData<DetailMangaResponse>()

    private var mangaPopuler = MutableLiveData<List<Manga>>()
    private var mangaRekomendasi = MutableLiveData<List<Manga>>()
    private var manhwas = MutableLiveData<List<Manga>>()
    private var manhuas = MutableLiveData<List<Manga>>()

    private var state : SingleLiveEvent<MangaState> = SingleLiveEvent()
    private var api = ApiClient.instance()

    fun fetchAllPost(pagenumber : Int){
        state.value = MangaState.IsLoading(true)
        api.allManga(pagenumber).enqueue(object : retrofit2.Callback<MangaListResponse<Manga>>{
            override fun onResponse(call: Call<MangaListResponse<Manga>>, response: Response<MangaListResponse<Manga>>) {
                if (response.isSuccessful){
                    val body = response.body() as MangaListResponse<Manga>
                    if (body.status!!.equals(true)){
                        val r = body.manga_list
                        mangas.postValue(r)
                    }
                }else{
                    state.value = MangaState.Error(Constans.RESPONSE_ERROR_MESSAGE)
                }
                state.value = MangaState.IsLoading(false)
            }

            override fun onFailure(call: Call<MangaListResponse<Manga>>, t: Throwable) {
                state.value = MangaState.Error(t.message)
            }

        })
    }

    fun fetchPopularManga(pagenumber: Int){
        state.value = MangaState.IsLoading(true)
        api.popularManga(pagenumber).enqueue(object : retrofit2.Callback<MangaListResponse<Manga>>{
            override fun onResponse(call: Call<MangaListResponse<Manga>>, response: Response<MangaListResponse<Manga>>) {
                if (response.isSuccessful){
                    val body = response.body() as MangaListResponse<Manga>
                    if (body.status!!.equals(true)){
                        val r = body.manga_list
                        mangaPopuler.postValue(r)
                    }
                }else{
                    state.value = MangaState.Error(Constans.RESPONSE_ERROR_MESSAGE)
                }
                state.value = MangaState.IsLoading(false)
            }

            override fun onFailure(call: Call<MangaListResponse<Manga>>, t: Throwable) {
                state.value = MangaState.Error(t.message)
            }

        })
    }

    fun fetchRekomendasiManga(){
        state.value = MangaState.IsLoading(true)
        api.recommendedManga().enqueue(object : retrofit2.Callback<MangaListResponse<Manga>>{
            override fun onResponse(call: Call<MangaListResponse<Manga>>, response: Response<MangaListResponse<Manga>>) {
                if (response.isSuccessful){
                    val body = response.body() as MangaListResponse<Manga>
                    if (body.status!!.equals(true)){
                        val r = body.manga_list
                        mangaRekomendasi.postValue(r)
                    }
                }else{
                    state.value = MangaState.Error(Constans.RESPONSE_ERROR_MESSAGE)
                }
                state.value = MangaState.IsLoading(false)
            }

            override fun onFailure(call: Call<MangaListResponse<Manga>>, t: Throwable) {
                state.value = MangaState.Error(t.message)
            }

        })
    }

    fun fetchManhwa(pagenumber: Int){
        state.value = MangaState.IsLoading(true)
        api.allManhwa(pagenumber).enqueue(object : retrofit2.Callback<MangaListResponse<Manga>>{
            override fun onResponse(call: Call<MangaListResponse<Manga>>, response: Response<MangaListResponse<Manga>>) {
                if (response.isSuccessful){
                    val body = response.body() as MangaListResponse<Manga>
                    if (body.status!!.equals(true)){
                        val r = body.manga_list
                        manhwas.postValue(r)
                    }
                }else{
                    state.value = MangaState.Error(Constans.RESPONSE_ERROR_MESSAGE)
                }
                state.value = MangaState.IsLoading(false)
            }

            override fun onFailure(call: Call<MangaListResponse<Manga>>, t: Throwable) {
                state.value = MangaState.Error(t.message)
            }
        })
    }

    fun fetchManhua(pagenumber: Int){
        state.value = MangaState.IsLoading(true)
        api.allManhua(pagenumber).enqueue(object : retrofit2.Callback<MangaListResponse<Manga>>{
            override fun onResponse(call: Call<MangaListResponse<Manga>>, response: Response<MangaListResponse<Manga>>) {
                if (response.isSuccessful){
                    val body = response.body() as MangaListResponse<Manga>
                    if (body.status!!.equals(true)){
                        val r = body.manga_list
                        manhuas.postValue(r)
                    }
                }else{
                    state.value = MangaState.Error(Constans.RESPONSE_ERROR_MESSAGE)
                }
                state.value = MangaState.IsLoading(false)
            }

            override fun onFailure(call: Call<MangaListResponse<Manga>>, t: Throwable) {
                state.value = MangaState.Error(t.message)
            }
        })
    }

    fun fetchOneManga(endpoint : String){
        state.value = MangaState.IsLoading(true)
        api.detailManga(endpoint).enqueue(object : retrofit2.Callback<DetailMangaResponse>{
            override fun onResponse(call: Call<DetailMangaResponse>, response: Response<DetailMangaResponse>) {
                if (response.isSuccessful){
                    val body = response.body() as DetailMangaResponse
                    manga.postValue(body)
                }else{
                    state.value = MangaState.Error(Constans.RESPONSE_ERROR_MESSAGE)
                }
                state.value = MangaState.IsLoading(false)
            }

            override fun onFailure(call: Call<DetailMangaResponse>, t: Throwable) {
                state.value = MangaState.Error(t.message)
            }
        })
    }

    fun getMangas() =  mangas
    fun getPopulerManga() = mangaPopuler
    fun getRekomendasiManga() = mangaRekomendasi
    fun getManhwas() = manhwas
    fun getManhuas() = manhuas

    fun getDetailManga() = manga

    fun getState() = state
}

sealed class MangaState{
    data class ShowToast(var message : String) : MangaState()
    data class IsLoading(var state : Boolean = false) : MangaState()
    data class Error(var err : String?) : MangaState()
    data class IsSuccess(var message: String? = null) : MangaState()
    object Reset : MangaState()
}