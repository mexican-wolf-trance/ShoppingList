package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.ui.createshoppinglist.AddItemFrag
import edu.charles_wyatt.shoppinglist.ui.createshoppinglist.CreateListActivity
import kotlinx.android.synthetic.main.create_list_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_view_list_recycler.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class ViewListFragment : Fragment(), ShoppingListRecyclerViewAdapter.Delegate
{
//    companion object
//    { fun newInstance() = ViewListFragment() }

    interface StateListener
    {
       fun goToTheFrag()
    }
    var listener: StateListener? = null


    private lateinit var listModel: ShoppingViewModel
    private lateinit var shoppingListRecyclerView: RecyclerView
    private lateinit var listAdapter: ShoppingListRecyclerViewAdapter
    private lateinit var addNewListButton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val view = inflater.inflate(R.layout.fragment_view_list_recycler, container, false)
        shoppingListRecyclerView = view.shopping_recycler_view
        shoppingListRecyclerView.layoutManager = LinearLayoutManager(activity)
        addNewListButton = view.add_new_list_btn
        addNewListButton.setOnClickListener()
        {
            listener?.goToTheFrag()
        }

        updateUI()
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        listModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        listModel.lists.observe(viewLifecycleOwner, Observer {
            listAdapter.setListCache(it)
        })
    }


    override fun selectedItemAtIndex(index: Int)
    {
        context?.let {context ->
            listModel.lists.value?.get(index)?.let {list ->
                val intent = CreateListActivity.newIntent(context, list.id)
                startActivity(intent)
            }
        }
    }


    private fun updateUI()
    {
        activity?.let {
            listAdapter = ShoppingListRecyclerViewAdapter(it)
            listAdapter.delegate = this
            shoppingListRecyclerView.adapter = listAdapter
        }
    }
}
