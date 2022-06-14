package com.example.assignment2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.Model.Post
import com.example.assignment2.R
import retrofit2.Callback

class CommentAdapter (
        private val Commentlist :List<Post>,
        val context : Callback<List<Post>>,
        private val onItemClicked:(position :Int)-> Unit
    ): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {



        class ViewHolder (
            ItemView : View,
            private val onItemClicked : (position : Int) -> Unit
        ) : RecyclerView. ViewHolder(ItemView), View.OnClickListener{

            val cmntid = itemView.findViewById<TextView>(R.id.textview_cmnt_id)
            val cmntbody = itemView.findViewById<TextView>(R.id.textview_cmnt_body)
            val cmntemail = itemView.findViewById<TextView>(R.id.textview_cmnt_emil)

            override fun onClick(p0: View?) {
                val position = adapterPosition
                onItemClicked(position)
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.comment_item,parent,false)
            return ViewHolder(view,onItemClicked)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val itemViewHolder = Commentlist[position]
        }

        override fun getItemCount(): Int {
            return Commentlist.size
        }
    }
