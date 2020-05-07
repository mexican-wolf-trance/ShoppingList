package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import edu.charles_wyatt.shoppinglist.R

class AddItemDiag : DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        return AlertDialog.Builder(context!!)
            .setView(R.layout.create_list_fragment)
            .setTitle("Shopping List Name")
            .setPositiveButton(android.R.string.ok) { dialog, buttonId ->
                val itemName = (dialog as AlertDialog).findViewById<EditText>(R.id.item_name)
                val itemPrice = (dialog as AlertDialog).findViewById<EditText>(R.id.item_price)
                val intent = Intent()
                intent.putExtra("shoppingItemName", itemName?.text.toString())
                intent.putExtra("shoppingItemPrice", itemPrice?.text.toString())
                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }
            .create()
    }
}

