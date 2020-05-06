package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import edu.charles_wyatt.shoppinglist.R

class AddItemDialogue : DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        return AlertDialog.Builder(context!!)
            .setView(R.layout.add_list_fragment)
            .setTitle("Shopping List Name")
            .setPositiveButton(android.R.string.ok) { dialog, buttonId ->
                val titleView = (dialog as AlertDialog).findViewById<EditText>(R.id.list_title)
                val intent = Intent()
                intent.putExtra("shoppingListName", titleView?.text.toString())
                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }
            .create()
    }
}