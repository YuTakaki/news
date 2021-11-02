package com.example.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface SetCategory {
    fun setCategory( category : String)
}

class CategoryAdaptor(
    val setCategory : SetCategory,
    val category: List<String>,
) : RecyclerView.Adapter<CategoryAdaptor.CategoryViewHolder>(){
    class CategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.itemView.apply{
            val textView = this.findViewById<TextView>(R.id.tv_category)
            textView.text = category[position]
        }

        holder.itemView.setOnClickListener {
            setCategory.setCategory(category[position])

        }

    }

    override fun getItemCount(): Int {

        return category.size
    }
}