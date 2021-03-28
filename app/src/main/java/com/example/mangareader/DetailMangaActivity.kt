package com.example.mangareader

//import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mangareader.utils.DetailMangaResponse
import com.example.mangareader.utils.MangaListResponse
import com.example.mangareader.viewmodels.MangaViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_manga.*


class DetailMangaActivity : AppCompatActivity() {
    private lateinit var mangaViewModel: MangaViewModel
    private lateinit var toolbar : Toolbar
    private lateinit var coll_toolbar : CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_manga)

//        toolbar = findViewById(R.id.tool_bar)
//        setSupportActionBar(toolbar)
//        coll_toolbar = findViewById(R.id.collapsing_toolbar_layout)
//        coll_toolbar.title = "Test Title"
//        coll_toolbar.setCollapsedTitleTextAppearance(R.style.coll_toolbar_title)
//        coll_toolbar.setExpandedTitleTextAppearance(R.style.exp_toolbar_title)
//        coll_toolbar.setContentScrimColor(Color.GREEN)

        mangaViewModel = ViewModelProviders.of(this).get(MangaViewModel::class.java)
        mangaViewModel.fetchOneManga(getEndpoint().toString())
        mangaViewModel.getDetailManga().observe(this, Observer {
            loadData(it)
        })
    }

    private fun loadData(manga : DetailMangaResponse){
//        coll_toolbar.title = manga.title

        txt_title_manga.text = manga.title
        txt_author_manga.text = "By "+manga.author
        txt_status.text = "Status : "+manga.status

        Picasso.get()
            .load(manga.thumb)
            .fit()
            .into(img_cover)

        txt_title_manga.isSelected = true
    }

    private fun getEndpoint() = intent.getStringExtra("endpoint")
}