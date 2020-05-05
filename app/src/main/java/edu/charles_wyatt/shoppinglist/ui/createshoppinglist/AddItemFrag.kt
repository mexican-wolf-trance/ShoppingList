package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

import edu.charles_wyatt.shoppinglist.R
import kotlinx.android.synthetic.main.add_list_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class AddItemFrag : Fragment() {

    @InternalCoroutinesApi
    private lateinit var listModel: CreateListViewModel
    private lateinit var listTitleVew: EditText
//    private lateinit var nameTitleView: EditText
//    private lateinit var priceTitleView: EditText
    private lateinit var submitBtnView: Button

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        listModel = ViewModelProvider(this).get(CreateListViewModel::class.java)

    }

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        Log.e("TAG", "In the frag add")
        val view = inflater.inflate(R.layout.add_list_fragment, container, false)

        listTitleVew = view.list_title
//        nameTitleView = view.name_title
//        priceTitleView = view.price_title
        submitBtnView = view.submit_btn

        submitBtnView.setOnClickListener()
        {
            listModel.save()
        }

        return view
    }
}
