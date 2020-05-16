package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_view_list.view.*

class ShoppingListHolder constructor(itemView: View):
    RecyclerView.ViewHolder(itemView), View.OnClickListener
{
    val listNameTextView: TextView = itemView.list_name
    val deleteButton: ImageButton = itemView.list_delete_btn

    init
    {
        listNameTextView.setOnClickListener(this)
    }

    private var onClickCallback: ((View) -> Unit)? = null
    fun setOnClickListener(callback: ((View) -> Unit)?)
    {
        onClickCallback = callback
    }

    override fun onClick(v: View?)
    {
        onClickCallback?.invoke(this.listNameTextView)
    }
}