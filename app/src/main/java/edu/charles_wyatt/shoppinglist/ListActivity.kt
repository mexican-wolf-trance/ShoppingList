package edu.charles_wyatt.shoppinglist

import androidx.fragment.app.Fragment
import edu.charles_wyatt.shoppinglist.base.SingleFragmentActivity

class ListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment = CreateListFragment.newInstance()
}