package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.shoppinglist.R
import kotlinx.android.synthetic.main.create_list_recycler_view.view.*

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

//    interface CreateListListener
//    {
//        fun toAddItemDiag()
//    }
//    var listener: CreateListListener? = null


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        listModel = ViewModelProvider(requireActivity()).get(CreateListViewModel::class.java)
        listModel.items.observe(viewLifecycleOwner, Observer {
            listAdapter.setListCache(it)
        })
        if(this::itemNameText.isInitialized)
        { setupUI() }

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.create_list_recycler_view, container,false)
        createListRecyclerView = view.create_list_recycler_view
        createListRecyclerView.layoutManager = LinearLayoutManager(activity)
        updateUI()

        addItemBtn = view.another
        addItemBtn.setOnClickListener()
        {
            val thisFrag = parentFragmentManager.beginTransaction()
            val prev = parentFragmentManager.findFragmentByTag("dialog")
            if (prev != null)
            {
                thisFrag.remove(prev)
            }
            thisFrag.addToBackStack(null)
            val diagFrag = AddItemDiag()
            diagFrag.setTargetFragment(this, Activity.RESULT_OK)
            diagFrag.show(thisFrag, "dialog")
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("TAG", "received a result: ${data?.getStringExtra("shoppingItemName")}")
        Log.e("TAG", "received a result: ${data?.getStringExtra("shoppingItemPrice")}")

        val name = data?.getStringExtra("shoppingItemName").toString()
        val price = data?.getStringExtra("shoppingItemPrice").toString().toDouble()
        listModel.createItemWith(name, price)
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
        itemNameText.text = listModel.item?.name
        itemPriceText.text = listModel.item?.price.toString()
        checkBox.isChecked = listModel.item?.isBought ?: false
    }




    override fun selectedItemAtIndex(index: Int)
    {
        context?.let {
            listModel.items.value?.get(index)?.let { item ->
                listModel.deleteItemAtIndex(item.id)
            }
        }
    }
}