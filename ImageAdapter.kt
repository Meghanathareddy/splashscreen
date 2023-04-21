package com.example.splashscreen


import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target


class Adapter(var urls: ArrayList<String>, context_: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    var context: Context = context_

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val image: ImageView = v.findViewById(R.id.img) as ImageView
        fun getImage(): ImageView {
            return image
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(urls[position])
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.getImage())
    }

    override fun getItemCount(): Int {
        return urls.size
    }

}