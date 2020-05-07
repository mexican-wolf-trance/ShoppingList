package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.charles_wyatt.shoppinglist.R

class ListActivity : AppCompatActivity()
{
    private var addFrag: ViewListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity_fragment)
        var fragment = (supportFragmentManager.findFragmentById(R.id.fragment_container))
        if (fragment == null)
        { fragment = ViewListFragment()  }

        if (!fragment.isAdded)
        {
            fragment = ViewListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }


        addFrag = fragment as ViewListFragment?
        addFrag?.listener = object : ViewListFragment.StateListener
        {
            override fun goToTheFrag()
            {
                val thisFrag = supportFragmentManager.beginTransaction()
                val prev = supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null)
                {
                    thisFrag.remove(prev)
                }
                thisFrag.addToBackStack(null)
                val diagFrag = AddListDialogue()
                diagFrag.setTargetFragment(addFrag, Activity.RESULT_OK)
                diagFrag.show(thisFrag, "dialog")
            }
        }
    }
}