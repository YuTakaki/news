package com.example.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.news.Article
import com.example.news.R

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val articleImg = findViewById<ImageView>(R.id.iv_articleDetailImg)
        val articleContent = findViewById<TextView>(R.id.tv_articleContent)
        val article = intent.getSerializableExtra("article")!! as Article;
        articleContent.text = article.content.toString()

    }

//    fun getSerialize(key : String) : String {
//        return intent.getSerializableExtra(key)
//    }
}