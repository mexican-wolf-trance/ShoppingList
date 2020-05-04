package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_view_list.view.*

class ShoppingListHolder constructor(itemView: View):
    RecyclerView.ViewHolder(itemView), View.OnClickListener
{
    val nameTextView: TextView = itemView.list_name

    init
    { itemView.setOnClickListener(this) }

    private var onClickCallback: ((View) -> Unit)? = null
    fun setOnClickListener(callback: ((View) -> Unit)?)
    {
        onClickCallback = callback
    }

    override fun onClick(v: View?)
    {
        onClickCallback?.invoke(this.itemView)
    }
}