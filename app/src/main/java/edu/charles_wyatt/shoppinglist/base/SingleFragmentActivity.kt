package edu.charles_wyatt.shoppinglist.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.charles_wyatt.shoppinglist.ui.viewshoppinglist.ViewListFragment
import edu.charles_wyatt.shoppinglist.R


abstract class SingleFragmentActivity: AppCompatActivity()
{
    protected abstract fun createFragment(): Fragment
    private var addFrag: ViewListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity_fragment)
        var fragment = (supportFragmentManager.findFragmentById(R.id.fragment_container))
        if (fragment == null)
        { fragment = createFragment() }

        if (!fragment.isAdded)
        {
            fragment = ViewListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }

//        addFrag?.listener = object: ViewListFragment.StateListener
//        {
//            override fun goToTheFrag()
//            {
//                var otherfragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as? AddItemFrag
//                if (otherfragment ==  null)
//                { otherfragment = AddItemFrag() }
//
//                if (!otherfragment.isAdded)
//                {
//                    supportFragmentManager.beginTransaction()
//                        .add(R.id.fragment_container, otherfragment)
//                        .commit()
//                }
//            }
//        }
    }
}