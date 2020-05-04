package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.ui.createshoppinglist.CreateListActivity
import kotlinx.android.synthetic.main.fragment_view_list_recycler.view.*

class ViewListFragment : Fragment(), ShoppingListRecyclerViewAdapter.Delegate
{
    companion object
    { fun newInstance() = ViewListFragment() }

    private lateinit var listModel: ShoppingViewModel
    private lateinit var shoppingListRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = inflater.inflate(R.layout.fragment_view_list_recycler, container, false)
        shoppingListRecyclerView = view.shopping_recycler_view
        shoppingListRecyclerView.layoutManager = LinearLayoutManager(activity)
        updateUI()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        listModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        updateUI()
    }

    override fun selectedItemAtIndex(index: Int)
    {
        context?.let {
            val intent = CreateListActivity.newIntent(it)
            startActivity(intent)
        }
    }


    private fun updateUI()
    {
        activity?.let {
            val adapter = ShoppingListRecyclerViewAdapter(it)
            adapter.delegate = this
            shoppingListRecyclerView.adapter = adapter
        }
    }


}
