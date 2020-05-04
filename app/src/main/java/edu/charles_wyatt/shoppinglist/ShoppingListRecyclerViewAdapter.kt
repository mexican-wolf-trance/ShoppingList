package edu.charles_wyatt.shoppinglist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ShoppingListRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<ShoppingListHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListHolder
    {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_create_list, parent, false)
        val holder = ShoppingListHolder(view)

//        holder.setOnClickListener
//        {
//
//        }
        return holder
    }

    override fun onBindViewHolder(holder: ShoppingListHolder, position: Int)
    {

    }

    override fun getItemCount(): Int = 0

}
