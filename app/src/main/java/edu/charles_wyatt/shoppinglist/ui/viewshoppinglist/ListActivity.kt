package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.base.SingleFragmentActivity
import edu.charles_wyatt.shoppinglist.ui.createshoppinglist.AddItemFrag
import edu.charles_wyatt.shoppinglist.ui.viewshoppinglist.ViewListFragment

class ListActivity : AppCompatActivity()
{
    private var addFrag: ViewListFragment? = null
    private var viewFrag: AddItemFrag? = null

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
                Log.e("TAG", "Frag button pressed")
//                var otherfragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as? AddItemFrag
//                if (otherfragment == null)
//                {
//                    otherfragment = AddItemFrag()
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, otherfragment)
//                        .commit()
//                }
                val thisFrag = supportFragmentManager.beginTransaction()
                val prev = supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null)
                {
                    thisFrag.remove(prev)
                }
                thisFrag.addToBackStack(null)
                val diagFrag = AddItemDialogue()
                diagFrag.show(thisFrag, "dialog")
            }


        }

        viewFrag = AddItemFrag()
        viewFrag?.listener = object : AddItemFrag.AddStateListener
        {
            override fun backToView()
            {
                Log.e("TAG", "Back to view!")
                var nextfragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as? ViewListFragment
                if (nextfragment == null) {
                    nextfragment = ViewListFragment()
                }

                if (!nextfragment.isAdded) {
                    nextfragment = ViewListFragment()
                    supportFragmentManager.beginTransaction()
                        .add(R.id.fragment_container, nextfragment)
                        .commit()
                }
            }
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("TAG", "received a result: ${data?.getStringExtra("shoppingListName")}")
    }
}