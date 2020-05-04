package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.charles_wyatt.shoppinglist.R
import kotlinx.android.synthetic.main.create_list_fragment.view.*

class CreateListFragment : Fragment()
{
    private lateinit var itemNameText: TextView
    private lateinit var itemPriceText: TextView
    private lateinit var checkBox: CheckBox


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_list_fragment, container,false)
        itemNameText = view.item_name
        itemPriceText = view.item_price
        checkBox = view.check_box

        return view
    }
}