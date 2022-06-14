package com.example.assignment2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.Model.Post
import com.example.assignment2.R
import retrofit2.Callback

class PostAdapter (
    private val Postlist :List<Post>,
    val context : Callback<List<Post>>,
    private val onItemClicked:(position :Int)-> Unit
    ): RecyclerView.Adapter<PostAdapter.ViewHolder>() {



    class ViewHolder (
            ItemView : View,
            private val onItemClicked : (position : Int) -> Unit
                ) : RecyclerView. ViewHolder(ItemView), View.OnClickListener{

        val id = itemView.findViewById<TextView>(R.id.textview_post_id)
        val title = itemView.findViewById<TextView>(R.id.textview_post_title)
        val body = itemView.findViewById<TextView>(R.id.textview_post_body)

        override fun onClick(p0: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_postitem,parent,false)
        return ViewHolder(view,onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   val itemViewHolder = Postlist[position]
    }

    override fun getItemCount(): Int {
        return Postlist.size
    }
}
