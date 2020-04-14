package edu.charles_wyatt.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity()
{
    private var createFrag: CreateListFragment? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        createFrag = supportFragmentManager.findFragmentById(R.id.main_list_activity) as? CreateListFragment
        if (createFrag == null)
        {
            createFrag = CreateListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_list_activity, createFrag!!)
                .commit()
        }
    }
}