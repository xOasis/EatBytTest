package bd.com.xbit.eatbyttest.Test

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bd.com.xbit.eatbyttest.R


class TestFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {




        return inflater.inflate(R.layout.test_fragment, container, false)
    }



    companion object {
            fun newInstance():TestFragment {
                return TestFragment()
            }
    }
}
