package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import edu.charles_wyatt.shoppinglist.R

import kotlinx.android.synthetic.main.activity_create_list.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.util.*

class CreateListActivity : AppCompatActivity()
{
    @InternalCoroutinesApi
    private lateinit var listModel: CreateListViewModel

    companion object
    {
        private const val EXTRA_LIST_ID = "edu.charles_wyatt.shoppinglist.id"

        fun newIntent(context: Context, listID: UUID): Intent
        {
            val intent = Intent(context, CreateListActivity::class.java)
            intent.putExtra(EXTRA_LIST_ID, listID)
            return intent
        }
    }
    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        var fragment = supportFragmentManager.findFragmentById(R.id.activity_create_list) as? CreateListFragment
        if (fragment ==  null)
        {
            fragment = CreateListFragment()
        }

        if (!fragment.isAdded)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_create_list, fragment)
                .commit()
        }
        listModel = ViewModelProvider(this).get(CreateListViewModel::class.java)
        intent?.let {
            val listID = it.getSerializableExtra(EXTRA_LIST_ID) as? UUID
            listID?.let{id ->
                listModel.loadList(id)
            }
        }
    }

    @InternalCoroutinesApi
    override fun onBackPressed()
    {
        super.onBackPressed()
        listModel.save()
    }
}
