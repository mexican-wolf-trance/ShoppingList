package edu.charles_wyatt.shoppinglist

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.shoppinglist.database.ShoppingList
import kotlinx.android.synthetic.main.fragment_create_list.view.*

class ShoppingListHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView)
{
    private val nameTextView: TextView = itemView.item_name
    private val priceTextView: TextView = itemView.item_price
    private val checkboxView: CheckBox = itemView.check_box

    fun bindShoppingList(list: ShoppingList)
    {
        nameTextView.text = list.itemName
        priceTextView.text = list.itemPrice.toString()
        checkboxView.isChecked = list.isBought
    }
}