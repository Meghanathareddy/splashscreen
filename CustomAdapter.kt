package com.example.splashscreen

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.splashscreen.model.Data

class CustomAdapter(var mList: List<Data>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //create new views
    override fun onCreateViewHolder(parent: ViewGroup,viewType:Int): ViewHolder{
        //inflates the card_view_design view
        //that is used to hold list item
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card_view_design,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        Glide.with(holder.imageView.context).load(item.avatar).circleCrop()
                .into(holder.imageView)

        holder.heading.text = item.first_name + item.last_name
        holder.subHeading.text = item.email
        Log.d("email","${item.email} \t ${holder.subHeading.text}")
        holder.time.text = item.id.toString()
//       when size of the data not changing only notifyItemChanged(holder.absoluteAdapterPosition)



    }

    override fun getItemCount(): Int {
        return mList.size
    }

    //Holds the view for adding it to image and text
    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var imageView:ImageView = itemView.findViewById(R.id.imageView)
        var heading:TextView = itemView.findViewById(R.id.heading)
        var subHeading:TextView = itemView.findViewById(R.id.subHeading)
        var time:TextView = itemView.findViewById(R.id.time)

    }


}

