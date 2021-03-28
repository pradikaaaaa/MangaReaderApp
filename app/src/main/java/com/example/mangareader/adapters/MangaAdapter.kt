package com.example.mangareader.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareader.DetailMangaActivity
import com.example.mangareader.R
import com.example.mangareader.models.Manga
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_manga.view.*
import kotlinx.android.synthetic.main.list_item_manga.view.img_thumb
import kotlinx.android.synthetic.main.list_item_manga.view.txt_title
import kotlinx.android.synthetic.main.list_item_manga_1.view.*

class MangaAdapter(private var mangas : MutableList<Manga>, private var context: Context) : RecyclerView.Adapter<MangaAdapter.ViewHolder>() {

    fun setMangas(r : List<Manga>){
        mangas.clear()
        mangas.addAll(r)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_manga,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mangas[position],context)
    }

    override fun getItemCount(): Int {
        return  mangas.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(manga : Manga, context: Context){
            itemView.txt_title.text = manga.title
//            if (!manga.type.isNullOrEmpty()){
//                itemView.rl_tipe.visibility
//                itemView.txt_kategori.text = manga.type
//            }

            Picasso.get()
                    .load(manga.thumb)
                    .into(itemView.img_thumb)

//            itemView.setOnClickListener {
//                context.startActivity(Intent(context, DetailMangaActivity::class.java).apply {
//                    putExtra("endpoint",manga.endpoint)
//                })
//            }
        }
    }
}