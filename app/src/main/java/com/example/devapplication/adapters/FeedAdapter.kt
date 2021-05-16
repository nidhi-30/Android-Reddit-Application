package com.example.devapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.devapplication.R
import com.example.devapplication.models.FeedDetail

class FeedAdapter(private val feedList: List<FeedDetail>,
                  private val listener : OnItemClickListener) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_list_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feed = feedList[position]

        holder.id.text = feed.data.author
        holder.category.text = feed.data.title

//        holder.itemView.setOnClickListener {
//            Log.d("clicked", "$feed")
//        }

    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    inner class FeedViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val id = itemView.findViewById(R.id.id) as TextView
        val category = itemView.findViewById(R.id.category) as TextView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


}