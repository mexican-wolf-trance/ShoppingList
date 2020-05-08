package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.charles_wyatt.shoppinglist.R
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList

class ShoppingListRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<ShoppingListHolder>()
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListHolder
    {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_view_list, parent, false)
        val holder = ShoppingListHolder(view)

        holder.setOnClickListener {
            delegate?.selectedItemAtIndex(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ShoppingListHolder, position: Int)
    {
        val list = lists[position]
        holder.listNameTextView.text = list.listName
    }

    override fun getItemCount(): Int
    {
        return lists.size
    }

}
