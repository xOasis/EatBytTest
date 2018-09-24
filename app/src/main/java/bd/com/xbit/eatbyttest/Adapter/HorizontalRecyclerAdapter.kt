package bd.com.xbit.eatbyttest.Adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import bd.com.xbit.eatbyttest.R
import com.bumptech.glide.Glide

class HorizontalRecyclerAdapter(val imageArray: Array<Int>) : RecyclerView.Adapter<HorizontalRecyclerAdapter.RecyclerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.friend_layout,parent,false)
        val holder = RecyclerViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return imageArray.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        Glide.with(holder.imageView!!.context).load(R.drawable.propic1).into(holder.imageView)

    }

    class RecyclerViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView!!.findViewById(R.id.profile_image)
    }

}