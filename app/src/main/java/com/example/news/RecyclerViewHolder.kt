package com.example.news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.news.activity.ArticleActivity
import com.squareup.picasso.Picasso

class RecyclerViewHolder (
    val context : Context,
    val newsList: NewsList
    ): RecyclerView.Adapter<RecyclerViewHolder.NewsViewHolder>() {

    class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val views = LayoutInflater.from(parent.context).inflate(R.layout.headline_item, parent, false)
        return NewsViewHolder(views)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList.articles[position]
        holder.itemView.apply{
            val title = this.findViewById<TextView>(R.id.header_title)
            val img = this.findViewById<ImageView>(R.id.headlineImg)
            title.text = news.title.toString()
            if (news.urlToImage != null) {
                Picasso.get().load(news.urlToImage).into(img)
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.articles.size
    }
}