package bd.com.xbit.eatbyttest.Root
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.View
import bd.com.xbit.eatbyttest.Kitchen.RootKitchenFragment
import bd.com.xbit.eatbyttest.Offers.RootOffersFragment
import bd.com.xbit.eatbyttest.Profile.RootProfileFragment
import bd.com.xbit.eatbyttest.Tales.RootTalesFragment
import android.util.DisplayMetrics
import android.support.v4.app.FragmentManager
import android.util.Log
import android.view.WindowManager
import bd.com.xbit.eatbyttest.R
import bd.com.xbit.eatbyttest.LibraryClasses.bottom_navigation


/**
 *  This is root class for hosting all Tales, Kitchens, Offers and Profile Section
 */

class RootActivity : AppCompatActivity() {

     var savedInstanceState: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        if(savedInstanceState != null )
            this.savedInstanceState = savedInstanceState

        fullScreen()
        val bottomNavigation: bottom_navigation?                                  //this is a custom bottom_navigation_view url:https://github.com/ittianyu/BottomNavigationViewEx
        bottomNavigation = findViewById(R.id.bottomNavigationView)
        bottomNavigation.enableShiftingMode(false)
        bottomNavigation.setItemIconTintList(null)                                //without this code,items of bottom-navigation remains dark

        val fragment = RootTalesFragment.newInstance()                           //when this activity first runs, initialize tales fragment
        replaceFragment(fragment)

        val menu:Menu = bottomNavigation.menu
        bottomNavigation.setOnNavigationItemSelectedListener { item->

            when (item.itemId) {

                R.id.first_fragment_item -> {
                    val fragment = RootTalesFragment.newInstance()
                    replaceFragment(fragment)
                    selectUnselectBottomTab(menu, R.drawable.ic_icon_tales_selected,0)

                }
                R.id.second_fragment_item -> {
                    val fragment = RootKitchenFragment.newInstance()
                    replaceFragment(fragment)
                    selectUnselectBottomTab(menu, R.drawable.ic_icon_kitchen_selected,1)
                }
                R.id.third_fragment_item -> {
                    val fragment = RootOffersFragment.newInstance()
                    replaceFragment(fragment)
                    selectUnselectBottomTab(menu, R.drawable.ic_icon_offers_selected,2)
                }
                R.id.fourth_fragment_item -> {
                    val fragment = RootProfileFragment.newInstance()
                    replaceFragment(fragment)
                    selectUnselectBottomTab(menu, R.drawable.ic_icon_profile_selected,3)
                }

            }

            return@setOnNavigationItemSelectedListener true

        }

    }


    /**
     *
     *  this method is for select and deselect bottom menu items
     *  @param menu
     *  @param drawableId for selected item drawable
     *  @param itemNumber for selected menu Item
     *  @return nothing
     *
     */

    fun selectUnselectBottomTab(menu: Menu,drawableId: Int,itemNumber: Int) {
             for (i in 0 until menu.size()) {
                                                                                    //this block is kept for loop example purpose in kotlin
        }
        menu.getItem(0).setIcon(R.drawable.ic_icon_tales_unselected)
        menu.getItem(1).setIcon(R.drawable.ic_icon_kitchen_unselected)
        menu.getItem(2).setIcon(R.drawable.ic_icon_offer_unselected)
        menu.getItem(3).setIcon(R.drawable.ic_icon_profile_unselected)

        menu.getItem(itemNumber).setIcon(drawableId)                               // this is for setting drawable on selected item on menu
    }


    /**
     *
     *  this method is for adding and resuming fragment
     *   @param fragment to add
     */

    fun replaceFragment(fragment: Fragment) {
        if(savedInstanceState == null) {
            var nameOfFragment: String? = fragment::class.simpleName
            var fragmentTransaction = supportFragmentManager.beginTransaction()
            var fm: FragmentManager = supportFragmentManager
            if (supportFragmentManager.findFragmentByTag(nameOfFragment) == null) {
                fragmentTransaction.add(R.id.root_fragments, fragment, nameOfFragment)      //if fragment is not added to the backstack,add it/ don't use replace because it creates new fragment emptying fragment container
                fragmentTransaction.addToBackStack(nameOfFragment)
                fragmentTransaction.commit()
            } else {
                var fragmentToShow: Fragment = supportFragmentManager.findFragmentByTag(nameOfFragment) //if fragment is already in backstack,show it and hide all other fragments.
                for (i in 0 until fm.backStackEntryCount) {
                    var fragmentToHide: Fragment = fm.findFragmentByTag(fm.getBackStackEntryAt(i).name)
                    if (fragmentToHide::class.simpleName != fragment::class.simpleName)
                        fragmentTransaction.hide(fragmentToHide)
                }
                fragmentTransaction.show(fragmentToShow)
                fragmentTransaction.commit()
            }
        }

    }


    /**
     * this method is for hiding status bar, no @param
     *  url : https://developer.android.com/training/system-ui/status
     */

    fun fullScreen() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()
    }


    private fun getScreenResolution(context: Context): String {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        return "{$width,$height}"
    }

}

