package bd.com.xbit.eatbyttest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_root)

        setContentView(R.layout.test_layout)
        val bottomNavigation: bottom_navigation?                                  //this is a custom bottom_navigation_view url:https://github.com/ittianyu/BottomNavigationViewEx
        bottomNavigation = findViewById(R.id.bottomNavigationView)
        bottomNavigation.enableShiftingMode(false)
        bottomNavigation.setItemIconTintList(null)

        bottomNavigation.setOnNavigationItemSelectedListener { item->

            when(item.itemId){

                R.id.first_fragment_item->{
                    item.setIcon(R.drawable.ic_icon_dish_unselected)

                }
                R.id.second_fragment_item->{
                    item.setIcon(R.drawable.ic_icon_tales_selected)
                }


            }

            return@setOnNavigationItemSelectedListener true

        }


    }
}

