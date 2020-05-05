package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.shoppinglist.R
import kotlinx.android.synthetic.main.create_list_fragment.view.*
import kotlinx.android.synthetic.main.create_list_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_view_list.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class CreateListFragment : Fragment(), CreateListRecyclerViewAdapter.Delegate {
    private lateinit var itemNameText: EditText
    private lateinit var itemPriceText: EditText
//    private lateinit var listName: EditText
    private lateinit var checkBox: CheckBox
    @InternalCoroutinesApi
    private lateinit var listModel: CreateListViewModel
    private lateinit var createListRecyclerView: RecyclerView
    private lateinit var listAdapter: CreateListRecyclerViewAdapter

    @InternalCoroutinesApi
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        listModel = ViewModelProvider(activity!!).get(CreateListViewModel::class.java)
        listModel.lists.observe(viewLifecycleOwner, Observer {
            listAdapter.setListCache(it)
        })
        setupUI()
    }


    @InternalCoroutinesApi
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.create_list_recycler_view, container,false)
//        val otherview = inflater.inflate(R.layout.fragment_view_list, container, false)
        createListRecyclerView = view.create_list_recycler_view
        createListRecyclerView.layoutManager = LinearLayoutManager(activity)
        updateUI()

//        itemNameText = view.item_name
//        itemPriceText = view.item_price
//        checkBox = view.check_box
//        listName = otherview.list_name
//
//        listName.addTextChangedListener(listNameWatcher)
//        itemNameText.addTextChangedListener(editTextWatcher)
//        itemPriceText.addTextChangedListener(editTextWatcher)
//        checkBox.setOnCheckedChangeListener { _, isChecked ->
//            listModel.list.isBought = isChecked
//        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shopping_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId)
        {
            R.id.add_shopping_list_option ->
            {
                val intent = Intent(context, CreateListActivity::class.java)
                startActivity(intent)
                true
            }
            else ->
            {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateUI()
    {
        activity?.let {
            listAdapter = CreateListRecyclerViewAdapter(it)
            listAdapter.delegate = this
            createListRecyclerView.adapter = listAdapter
        }
    }

    @InternalCoroutinesApi
    private fun setupUI()
    {
//        itemNameText.setText(listModel.list.item)
//        itemPriceText.setText(listModel.list.price)
//        checkBox.isChecked = listModel.list.isBought
    }

    @InternalCoroutinesApi
    private val editTextWatcher = object: TextWatcher
    {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
        {
            s?.let {
                listModel.list.item = it.toString()
                listModel.list.price = it.toString()
            }
        }
    }

    @InternalCoroutinesApi
    override fun selectedItemAtIndex(index: Int)
    {
        context?.let {context ->
            listModel.lists.value?.get(index)?.let {list ->
                val intent = CreateListActivity.newIntent(context, list.id)
                startActivity(intent)
            }
        }
    }
}