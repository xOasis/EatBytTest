package bd.com.xbit.eatbyttest.Adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import bd.com.xbit.eatbyttest.R
import java.util.*


class RecyclerAdpater(val size: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val VERTICAL:Int = 1
    val HORIZONTAL:Int = 2
    lateinit var context: Context
    var imageArray = arrayOf(R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8)
    var vertical_scrolled:Boolean = false
    var horizontal_scrolled:Boolean = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflater:LayoutInflater = LayoutInflater.from(parent.context)
        context = parent.context
        lateinit var view:View
        lateinit var holder:RecyclerView.ViewHolder

        when(viewType){
            VERTICAL-> {
                view = inflater.inflate(R.layout.root_vertical_recyclerview,parent,false)
                holder =  VerticalViewHolder(view)
            }

            HORIZONTAL-> {
                view = inflater.inflate(R.layout.root_horizontal_recyclerview,parent,false)
                holder = HorizontalViewHolder(view)
            }

        }

        return holder
    }

    override fun getItemViewType(position: Int): Int {
        if (size > 1) {
            if (position == 0 || position == 2) {
                return VERTICAL
            } else {
                return HORIZONTAL
            }
        } else {
            return VERTICAL
        }
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == VERTICAL){
            verticalView(holder as VerticalViewHolder)
        }
        else if(holder.itemViewType == HORIZONTAL){
            horizontalView(holder as HorizontalViewHolder)
        }

    }

    private fun verticalView(holder: VerticalViewHolder) {
        val adapter = VerticalRecyclerAdapter(imageArray)
        holder.recyclerView.layoutManager = LinearLayoutManager(context)
        holder.recyclerView.adapter = adapter
    }


    private fun horizontalView(holder: HorizontalViewHolder) {
        val adapter = HorizontalRecyclerAdapter(imageArray)
        holder.recyclerView.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
        holder.recyclerView.setAdapter(adapter)
    }

}