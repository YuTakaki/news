package com.example.news.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
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

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = R.layout.activity_main
        setContentView(view)

        val navController = findNavController(R.id.hostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)



//        val navController = this.findNavController(R.id.hostFragment)
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
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

    override fun onSupportNavigateUp(): Boolean {
        val navController =  findNavController(R.id.hostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
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


