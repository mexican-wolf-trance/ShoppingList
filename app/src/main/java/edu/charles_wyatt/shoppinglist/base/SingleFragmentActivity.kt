package edu.charles_wyatt.shoppinglist.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import edu.charles_wyatt.shoppinglist.CreateListFragment
import edu.charles_wyatt.shoppinglist.R


abstract class SingleFragmentActivity: AppCompatActivity()
{
    protected abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        var fragment = (supportFragmentManager.findFragmentById(R.id.fragment_container))
        if (fragment == null)
        {
            fragment = createFragment()
        }

        if (!fragment.isAdded)
        {
            fragment = CreateListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}