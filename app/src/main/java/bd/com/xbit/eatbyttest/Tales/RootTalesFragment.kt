package bd.com.xbit.eatbyttest.Tales

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bd.com.xbit.eatbyttest.R
import bd.com.xbit.eatbyttest.Tab
import com.nshmura.recyclertablayout.RecyclerTabLayout
import kotlinx.android.synthetic.main.activity_root.view.*
import kotlinx.android.synthetic.main.tales_root_fragment.*


class RootTalesFragment : Fragment() {

    lateinit var layout: View
    lateinit var viewPager:ViewPager
    lateinit var fm: FragmentManager
    //lateinit var recyclerTabLayout: RecyclerTabLayout
    lateinit var recyclerTabLayout: Tab
    lateinit var tab:Tab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.tales_root_fragment, container, false)

        recyclerTabLayout = layout.findViewById(R.id.talesTabLayout)

        fm = this.fragmentManager!!

        viewPager = layout.findViewById(R.id.viewPager)
        viewPager.adapter = TalesPagerAdapter(fm)
        viewPager.currentItem = TalesPagerAdapter(fm).count/2
        recyclerTabLayout.setUpWithViewPager(viewPager)

        return layout
    }


    companion object {

        fun newInstance(): RootTalesFragment {
            return RootTalesFragment()
        }

    }
}
