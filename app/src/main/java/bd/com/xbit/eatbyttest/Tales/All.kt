package bd.com.xbit.eatbyttest.Tales

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import bd.com.xbit.eatbyttest.R
import com.bumptech.glide.Glide

class All: Fragment() {

    lateinit var layout: View
    val animals: ArrayList<String> = ArrayList()
    lateinit var  recyclerView:RecyclerView
    var imageArray = arrayOf(R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        layout = inflater.inflate(R.layout.tales_all_fragment,container,false)
        recyclerView = layout.findViewById(R.id.tales_all_recyclerView)
        recyclerView.setHasFixedSize(false)
        recyclerView.isNestedScrollingEnabled = true
        recyclerView.layoutManager = LinearLayoutManager(this!!.activity)
        return layout

    }


    override fun onResume() {
        super.onResume()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        recyclerView.adapter = RecyclerAdpater(imageArray)

    }

    companion object {
        fun newInstance(): All {
            return All()
        }
    }

    private class RecyclerAdpater(val imageArray: Array<Int>) : RecyclerView.Adapter<RecyclerAdpater.RecyclerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val view:View = LayoutInflater.from(parent.context).inflate(R.layout.tales_review_list_layout,parent,false)
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


        class RecyclerViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

            //val textView = itemView?.findViewById<TextView>(R.id.tales_textView)
            val foodImage = itemView?.findViewById<ImageView>(R.id.list_post_food_id)
            val propic = itemView?.findViewById<ImageView>(R.id.profile_image)

        }

    }



}