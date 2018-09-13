package bd.com.xbit.eatbyttest.Tales

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class TalesPagerAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm){

    private val MAX_VALUE = 200
    private val fragmentNumber = 3
    private val nammeFragmentArray = arrayOf("All","Reviews","Ask")

    override fun getItem(position: Int): Fragment {

        lateinit var fragment:Fragment

        if(position%fragmentNumber == 0) {
            fragment = All.newInstance()
        }
        else if(position%fragmentNumber == 1){
            fragment = Reviews.newInstance()
        }
        else if(position%fragmentNumber == 2){
            fragment = Ask.newInstance()
        }

        return fragment
    }

    override fun getCount(): Int {
        return fragmentNumber * MAX_VALUE
        //return fragmentNumber
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return nammeFragmentArray[position%fragmentNumber]
    }

}