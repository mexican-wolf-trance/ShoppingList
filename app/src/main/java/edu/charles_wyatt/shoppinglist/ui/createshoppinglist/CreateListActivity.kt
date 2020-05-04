package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import edu.charles_wyatt.shoppinglist.R

import kotlinx.android.synthetic.main.activity_create_list.*

class CreateListActivity : AppCompatActivity()
{
    companion object
    {
        fun newIntent(context: Context): Intent
        {
            val intent = Intent(context, CreateListActivity::class.java)
            //intent.putExtra()
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)


    }

}
