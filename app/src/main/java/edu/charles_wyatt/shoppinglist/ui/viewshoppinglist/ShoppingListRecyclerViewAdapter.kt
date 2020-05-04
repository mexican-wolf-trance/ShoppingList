package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.database.ShoppingList

class ShoppingListRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<ShoppingListHolder>()
{
    var dataSource: DataSource? = null
    interface DataSource
    {
        val itemCount: Int
        fun dataAtIndex(index: Int): ShoppingList?
    }

    var delegate: Delegate? = null
    interface Delegate
    {
        fun selectedItemAtIndex(index: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListHolder
    {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_view_list, parent, false)
        val holder =
            ShoppingListHolder(
                view
            )

        holder.setOnClickListener {
            delegate?.selectedItemAtIndex(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ShoppingListHolder, position: Int)
    {
        val list = ShoppingList()
        list.itemName = "Lettuce"
//        list.itemPrice = "3.50"
 //       dataSource?.dataAtIndex(position)?.let{list ->
            holder.nameTextView.text = list.itemName
//            holder.priceTextView.text = list.itemPrice
//            holder.checkboxView.isChecked = list.isBought
//            holder.bindShoppingList(list)
  //      }

    }

    override fun getItemCount(): Int
    {
        return 3
//        return dataSource?.itemCount ?: 0
    }

}
