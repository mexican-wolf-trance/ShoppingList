package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.Button
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
import kotlinx.android.synthetic.main.create_list_recycler_view.*
import kotlinx.android.synthetic.main.create_list_recycler_view.view.*
import kotlinx.android.synthetic.main.create_list_recycler_view.view.another
import kotlinx.android.synthetic.main.fragment_view_list.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class CreateListFragment : Fragment(), CreateListRecyclerViewAdapter.Delegate
{
    private lateinit var itemNameText: TextView
    private lateinit var itemPriceText: TextView
    private lateinit var checkBox: CheckBox
    private lateinit var addItemBtn: Button

    private lateinit var listModel: CreateListViewModel
    private lateinit var createListRecyclerView: RecyclerView
    private lateinit var listAdapter: CreateListRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    interface CreateListListener
    {
        fun toAddItemDiag()
    }
    var listener: CreateListListener? = null


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        listModel = ViewModelProvider(activity!!).get(CreateListViewModel::class.java)
        listModel.lists.observe(viewLifecycleOwner, Observer {
            listAdapter.setListCache(it)
        })
        setupUI()

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.create_list_recycler_view, container,false)
        val otherview = inflater.inflate(R.layout.create_list_fragment, container, false)
        createListRecyclerView = view.create_list_recycler_view
        createListRecyclerView.layoutManager = LinearLayoutManager(activity)
        updateUI()

        itemNameText = otherview.item_name
        itemPriceText = otherview.item_price
        checkBox = otherview.check_box

        addItemBtn = view.another
        addItemBtn.setOnClickListener()
        {
            listener?.toAddItemDiag()
        }


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

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
//    {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.create_list_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean
//    {
//        return when (item.itemId)
//        {
//            R.id.add_create_list_option ->
//            {
//                val intent = Intent(context, CreateListActivity::class.java)
//                startActivity(intent)
//                true
//            }
//            else ->
//            {
//                super.onOptionsItemSelected(item)
//            }
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("TAG", "received a result: ${data?.getStringExtra("shoppingItemName")}")
        Log.e("TAG", "received a result: ${data?.getStringExtra("shoppingItemPrice")}")
        listModel.list.item = data?.getStringExtra("shoppingItemName").toString()
        listModel.list.price = data?.getStringExtra("shoppingItemPrice").toString()
        context?.let {
            listModel.save()
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


    private fun setupUI()
    {
        itemNameText.text = listModel.list.item
        itemPriceText.text = listModel.list.price
        checkBox.isChecked = listModel.list.isBought
    }


//    private val editTextWatcher = object: TextWatcher
//    {
//        override fun afterTextChanged(s: Editable?) {}
//        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
//        {
//            s?.let {
//                listModel.list.item = it.toString()
//                listModel.list.price = it.toString()
//            }
//        }
//    }


    override fun selectedItemAtIndex(index: Int)
    {
//        context?.let {context ->
//            listModel.lists.value?.get(index)?.let {list ->
//                val intent = CreateListActivity.newIntent(context, list.id)
//                startActivity(intent)
//            }
//        }
    }
}