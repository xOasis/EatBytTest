package bd.com.xbit.eatbyttest.Kitchen


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bd.com.xbit.eatbyttest.R


class RootKitchenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.kitchen_root_fragment, container, false)
    }


    companion object {
            fun newInstance() : RootKitchenFragment {

                return RootKitchenFragment()

            }
    }
}