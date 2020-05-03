package edu.charles_wyatt.shoppinglist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_create_list_list.*
import edu.charles_wyatt.shoppinglist.Persistance.Entities.ShoppingListEntity

class CreateListFragment : Fragment()
{
    private var listener: ShoppingListViewListener? = null
    interface ShoppingListViewListener
    {
        val item: List<String>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {return inflater.inflate(R.layout.fragment_create_list_list, container, false)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        shopping_list_view.layoutManager = LinearLayoutManager(activity)
        shopping_list_view.adapter = ShoppingListAdapter()
    }

    inner class ShoppingListAdapter: RecyclerView.Adapter<ShoppingListHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListHolder
        {
            val inflater = LayoutInflater.from(activity)
            val itemView = inflater.inflate(R.layout.fragment_create_list, parent, false)
            return ShoppingListHolder(itemView)
        }

        override fun getItemCount(): Int = listener?.item?.size ?: 0

        override fun onBindViewHolder(holder: ShoppingListHolder, position: Int)
        {
            listener?.item?.get(position)?.let {
                holder.bindTitle(it)
            }
        }
    }
    class ShoppingListHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        private val titleTextView: TextView = itemView.findViewById(R.id.item_name)
        private val priceTextView: TextView = itemView.findViewById(R.id.item_price)

        fun bindTitle(title: String)
        {
            titleTextView.text = title
            priceTextView.text = null
        }
    }
}
