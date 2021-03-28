package com.example.mangareader.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareader.R
import com.example.mangareader.adapters.MangaAdapter
import com.example.mangareader.adapters.MangaBannerAdapter
import com.example.mangareader.viewmodels.MangaState
import com.example.mangareader.viewmodels.MangaViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var mangaViewModel: MangaViewModel
    private lateinit var rv_rekomendasi: RecyclerView
    private lateinit var rv_populer: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home,container,false)

        root.apply {
            rv_rekomendasi = findViewById(R.id.img_banner)
            rv_populer = findViewById(R.id.rv_manga_populer)
        }

        setupRecyler()

        mangaViewModel = ViewModelProviders.of(this).get(MangaViewModel::class.java)
        mangaViewModel.fetchRekomendasiManga()
        mangaViewModel.getRekomendasiManga().observe(this@HomeFragment.viewLifecycleOwner, Observer {
            rv_rekomendasi.adapter?.let { adapter ->
                if(adapter is MangaAdapter){
                    adapter.setMangas(it)
                }
            }
        })

//        mangaViewModel.fetchPopularManga(1)
//        mangaViewModel.getPopulerManga().observe(this@HomeFragment.viewLifecycleOwner, Observer {
//            rv_populer.adapter?.let { adapter ->
//                if (adapter is MangaAdapter){
//                    adapter.setMangas(it)
//                }
//            }
//        })

        mangaViewModel.getState().observer(this, Observer {
            handleUIState(it)
        })

        return root
    }

    private fun setupRecyler(){
        rv_rekomendasi.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = MangaAdapter(mutableListOf(),this@HomeFragment.requireContext())
        }

//        rv_populer.apply {
//            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext(),LinearLayoutManager.HORIZONTAL,false)
//            adapter = MangaAdapter(mutableListOf(),this@HomeFragment.requireContext())
//        }
    }

    private fun handleUIState(it : MangaState){
        when(it){
            is MangaState.Error -> {
                toast(it.err)
            }
        }
    }

    private fun toast(message : String?) = Toast.makeText(this@HomeFragment.requireContext(), message, Toast.LENGTH_LONG).show()

}