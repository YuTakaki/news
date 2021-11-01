package com.example.news.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.ApiInterface
import com.example.news.NewsList
import com.example.news.R
import com.example.news.RecyclerViewHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData(this)
    }
    private fun getData(context: Context){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/")
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofitBuilder.getTopHeadlines()

        retrofitData.enqueue(object : Callback<NewsList?> {
            override fun onResponse(call: Call<NewsList?>, response: Response<NewsList?>) {
                val body = response.body()!!
                updateRecycleView(body, context)
            }

            override fun onFailure(call: Call<NewsList?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun updateRecycleView(body: NewsList, context: Context){
        val newsAdapter = RecyclerViewHolder(context, body)
        val rvNewsList = findViewById<RecyclerView>(R.id.rv_newsList)
        rvNewsList.adapter = newsAdapter
        rvNewsList.layoutManager = LinearLayoutManager(context)

    }

}
