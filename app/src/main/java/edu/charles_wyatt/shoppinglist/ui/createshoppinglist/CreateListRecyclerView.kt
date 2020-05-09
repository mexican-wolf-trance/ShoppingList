package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import edu.charles_wyatt.shoppinglist.database.listItems.Item

class CreateListRecyclerViewAdapter (private val context: Context) : RecyclerView.Adapter<CreateListHolder>()
{
    private var items: List<Item> = emptyList()

    var delegate: Delegate? = null
    interface Delegate
    {
        fun selectedItemAtIndex(index: Int)
    }

    fun setListCache(items: List<Item>)
    {
        this.items = items
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
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price.toString()
        holder.checkBox.isChecked = item.isBought
    }

    override fun getItemCount() = items.size
}
