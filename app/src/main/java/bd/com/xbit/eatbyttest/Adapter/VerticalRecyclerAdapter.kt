package bd.com.xbit.eatbyttest.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import bd.com.xbit.eatbyttest.R
import com.bumptech.glide.Glide

class VerticalRecyclerAdapter(val imageArray: Array<Int>) : RecyclerView.Adapter<VerticalRecyclerAdapter.RecyclerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.tales_review_list_layout,parent,false)
        val holder = RecyclerViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return imageArray.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        Glide.with(holder.foodImage!!.context).load(imageArray[position]).into(holder.foodImage!!)
        Glide.with(holder.foodImage!!.context).load(R.drawable.propic1).into(holder.propic!!)
    }


    class RecyclerViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView){
        val foodImage = itemView?.findViewById<ImageView>(R.id.list_post_food_id)
        val propic = itemView?.findViewById<ImageView>(R.id.profile_image)
    }

}