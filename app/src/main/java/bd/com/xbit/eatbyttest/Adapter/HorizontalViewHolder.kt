package bd.com.xbit.eatbyttest.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import bd.com.xbit.eatbyttest.R

class HorizontalViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal var recyclerView: RecyclerView

    init {
        recyclerView = itemView.findViewById(R.id.horizontalRecyclerView)
    }
}