package com.example.news.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.*
import com.example.news.fragments.MainFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class MainActivity : AppCompatActivity(){
//    private val context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val categories  = listOf<String>(
//            "business",
//            "entertainment",
//            "general",
//            "health",
//            "science",
//            "sports",
//            "technology"
//        )
//        val categoryAdapter = CategoryAdaptor(this, categories)
//        val rvCategory = findViewById<RecyclerView>(R.id.rv_categories)
//        rvCategory.adapter = categoryAdapter
//        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        getData("business")
    }
//    private fun getData(category : String){
//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://newsapi.org/v2/")
//            .build()
//            .create(ApiInterface::class.java)
//
//
//        val retrofitData = retrofitBuilder.getTopHeadlines(category)
//
//        retrofitData.enqueue(object : Callback<NewsList?> {
//            override fun onResponse(call: Call<NewsList?>, response: Response<NewsList?>) {
//                val body = response.body()!!
//                updateRecycleView(body)
//            }
//
//            override fun onFailure(call: Call<NewsList?>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//    }
//
//    private fun updateRecycleView(body: NewsList){
//        val newsAdapter = RecyclerViewHolder(this, body)
//        val rvNewsList = findViewById<RecyclerView>(R.id.rv_newsList)
//        rvNewsList.adapter = newsAdapter
//        rvNewsList.layoutManager = LinearLayoutManager(this)
//    }
//
//    override fun seeNews(news: Article) {
//        Log.d("asasd", news.title)
//        Intent(this, ArticleActivity::class.java).also{
//            it.putExtra("article", news)
//            startActivity(it)
//        }
//    }
//
//    override fun setCategory(category: String) {
//        getData(category)
//    }
}

