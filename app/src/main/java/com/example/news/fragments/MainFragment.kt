package com.example.news.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.*
import com.example.news.activity.ArticleActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainFragment : Fragment(), SeeNews, SetCategory {

    private lateinit var views : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        views = inflater.inflate(R.layout.fragment_main, container, false)

        return views
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categories  = listOf<String>(
            "business",
            "entertainment",
            "general",
            "health",
            "science",
            "sports",
            "technology"
        )
        val categoryAdapter = CategoryAdaptor(this, categories)
        val rvCategory = views.findViewById<RecyclerView>(R.id.rv_categories)
        rvCategory.adapter = categoryAdapter
        rvCategory.layoutManager = LinearLayoutManager(views.context, LinearLayoutManager.HORIZONTAL, false)
        getData("business")
    }



    private fun getData(category : String){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/")
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofitBuilder.getTopHeadlines(category)

        retrofitData.enqueue(object : Callback<NewsList?> {
            override fun onResponse(call: Call<NewsList?>, response: Response<NewsList?>) {
                val body = response.body()!!
                updateRecycleView(body)
            }

            override fun onFailure(call: Call<NewsList?>, t: Throwable) {

            }
        })
    }

    private fun updateRecycleView(body: NewsList){
        val newsAdapter = RecyclerViewHolder(this, body)
        val rvNewsList = views.findViewById<RecyclerView>(R.id.rv_newsList)
        rvNewsList.adapter = newsAdapter
        rvNewsList.layoutManager = LinearLayoutManager(views.context)
    }

    override fun seeNews(news: Article) {
//        Intent(views.context, ArticleActivity::class.java).also{
//            it.putExtra("article", news)
//            startActivity(it)
//        }
        Log.d("ddd", "wfwfwefwefe")

        Navigation.findNavController(views).navigate(R.id.action_mainFragment_to_articleFragment)

    }

    override fun setCategory(category: String) {
        getData(category)
    }

}