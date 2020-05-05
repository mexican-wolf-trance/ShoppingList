package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.base.SingleFragmentActivity
import edu.charles_wyatt.shoppinglist.ui.createshoppinglist.AddItemFrag
import edu.charles_wyatt.shoppinglist.ui.viewshoppinglist.ViewListFragment

class ListActivity : AppCompatActivity() {
    private var addFrag: ViewListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity_fragment)
        var fragment = (supportFragmentManager.findFragmentById(R.id.fragment_container))
        if (fragment == null) {
            fragment = ViewListFragment()
        }

        if (!fragment.isAdded) {
            fragment = ViewListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }

        addFrag?.listener = object : ViewListFragment.StateListener
        {
            override fun goToTheFrag()
            {
                Log.e("TAG", "Frag button pressed")
                var otherfragment = supportFragmentManager.findFragmentById(R.id.fragment_container2) as? AddItemFrag
                if (otherfragment == null)
                {
                    otherfragment = AddItemFrag()
                    supportFragmentManager.beginTransaction()
                        .add(R.id.fragment_container2, otherfragment)
                        .commit()
                }
            }
        }
    }
}