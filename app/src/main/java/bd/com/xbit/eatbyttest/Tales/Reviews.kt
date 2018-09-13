package bd.com.xbit.eatbyttest.Tales

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bd.com.xbit.eatbyttest.R

class Reviews:Fragment() {

    lateinit var layout: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layout = inflater.inflate(R.layout.tales_reviews_fragment,container,false)
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    companion object {
        fun newInstance(): Reviews {
            return Reviews()
        }
    }
}
