package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.create_list_fragment.view.*

class CreateListHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
{
    val nameTextView: TextView = itemView.item_name
    val priceTextView: TextView = itemView.item_price
    val checkBox: CheckBox = itemView.check_box
    val deleteButton: ImageButton? = itemView.delete_btn

    init
    { deleteButton?.setOnClickListener(this) }

    private var onClickCallback: ((View) -> Unit)? = null

    fun setOnClickListener(callback: ((View) -> Unit)?)
    { onClickCallback = callback }

    override fun onClick(v: View?)
    { onClickCallback?.invoke(this.itemView) }
}