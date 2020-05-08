package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.database.ShoppingList

class CreateListRecyclerViewAdapter (private val context: Context) :
    RecyclerView.Adapter<CreateListHolder>()
{
    private var lists: List<ShoppingList> = emptyList()

    var delegate: Delegate? = null
    interface Delegate
    {
        fun selectedItemAtIndex(index: Int)
    }

    fun setListCache(lists: List<ShoppingList>)
    {
        this.lists = lists
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateListHolder
    {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.create_list_fragment, parent, false)
        val holder = CreateListHolder(view)

        holder.setOnClickListener {
            delegate?.selectedItemAtIndex(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: CreateListHolder, position: Int)
    {
        val list = lists[position]
        holder.nameTextView.text = list.item
        holder.priceTextView.text = list.price
        holder.checkBox.isChecked = list.isBought
    }

    override fun getItemCount(): Int
    {
        return lists.size
    }

}
