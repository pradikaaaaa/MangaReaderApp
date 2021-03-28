package com.example.mangareader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangareader.adapters.MangaAdapter
import com.example.mangareader.viewmodels.MangaState
import com.example.mangareader.viewmodels.MangaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var mangaViewModel: MangaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setupRecyler()

        mangaViewModel = ViewModelProviders.of(this).get(MangaViewModel::class.java)

//        rekomendasiManga()
//        populerManga()
//        Manhua()
//        Manhwa()

        mangaViewModel.getState().observer(this, Observer {
            handleUIState(it)
        })
    }

//    private fun setupRecyler(){
//        rv_manga_rekomendasi.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
//            adapter = MangaAdapter(mutableListOf(),this@MainActivity)
//        }
//
//        rv_manga_populer.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
//            adapter = MangaAdapter(mutableListOf(),this@MainActivity)
//        }
//
//        rv_manhwa.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
//            adapter = MangaAdapter(mutableListOf(),this@MainActivity)
//        }
//
//        rv_manhua.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
//            adapter = MangaAdapter(mutableListOf(),this@MainActivity)
//        }
//    }
//
//    private fun rekomendasiManga(){
//        mangaViewModel.fetchRekomendasiManga()
//        mangaViewModel.getRekomendasiManga().observe(this, Observer {
//            rv_manga_rekomendasi.adapter?.let { adapter ->
//                if(adapter is MangaAdapter){
//                    adapter.setMangas(it)
//                }
//            }
//        })
//    }
//
//    private fun populerManga(){
//        mangaViewModel.fetchPopularManga(1)
//        mangaViewModel.getPopulerManga().observe(this, Observer {
//            rv_manga_populer.adapter?.let { adapter ->
//                if (adapter is MangaAdapter){
//                    adapter.setMangas(it)
//                }
//            }
//        })
//    }
//
//    private fun Manhwa(){
//        mangaViewModel.fetchManhwa(1)
//        mangaViewModel.getManhwas().observe(this, Observer {
//            rv_manhwa.adapter?.let { adapter ->
//                if(adapter is MangaAdapter){
//                    adapter.setMangas(it)
//                }
//            }
//        })
//    }
//
//    private fun Manhua(){
//        mangaViewModel.fetchManhua(1)
//        mangaViewModel.getManhuas().observe(this, Observer {
//            rv_manhua.adapter?.let { adapter ->
//                if(adapter is MangaAdapter){
//                    adapter.setMangas(it)
//                }
//            }
//        })
//    }

    private fun handleUIState(it : MangaState){
        when(it){
            is MangaState.Error -> {
                toast(it.err)
            }
        }
    }

    private fun toast(message : String?) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()


}