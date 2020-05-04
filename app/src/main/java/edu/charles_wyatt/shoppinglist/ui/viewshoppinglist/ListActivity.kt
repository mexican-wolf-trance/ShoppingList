package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import androidx.fragment.app.Fragment
import edu.charles_wyatt.shoppinglist.base.SingleFragmentActivity
import edu.charles_wyatt.shoppinglist.ui.viewshoppinglist.ViewListFragment

class ListActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment = ViewListFragment.newInstance()
}