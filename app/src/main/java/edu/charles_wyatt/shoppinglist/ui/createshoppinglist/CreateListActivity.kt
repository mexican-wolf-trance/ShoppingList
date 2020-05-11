package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import edu.charles_wyatt.shoppinglist.R
import java.util.*

class CreateListActivity : AppCompatActivity()
{

    private lateinit var itemModel: CreateListViewModel
    private lateinit var addItemDiagFrag: CreateListFragment

    companion object
    {
        private const val EXTRA_LIST_ID = "edu.charles_wyatt.shoppinglist.database.shoppinglist.id"

        fun newIntent(context: Context, listId: UUID): Intent
        {
            val intent = Intent(context, CreateListActivity::class.java)
            intent.putExtra(EXTRA_LIST_ID, listId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_list)

        var fragment = supportFragmentManager.findFragmentById(R.id.activity_create_list) as? CreateListFragment
        if (fragment ==  null)
        { fragment = CreateListFragment() }

        if (!fragment.isAdded)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_create_list, fragment)
                .commit()
        }
        itemModel = ViewModelProvider(this).get(CreateListViewModel::class.java)
        intent?.let {
            val listID = it.getSerializableExtra(EXTRA_LIST_ID) as? UUID
            listID?.let{id ->
                itemModel.loadList(id)
                itemModel.setListId(id)
            }
        }

        addItemDiagFrag = fragment
        addItemDiagFrag.listener = object : CreateListFragment.CreateListListener
        {
            override fun toAddItemDiag()
            {
                val thisFrag = supportFragmentManager.beginTransaction()
                val prev = supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null)
                {
                    thisFrag.remove(prev)
                }
                thisFrag.addToBackStack(null)
                val diagFrag = AddItemDiag()
                diagFrag.setTargetFragment(addItemDiagFrag, Activity.RESULT_OK)
                diagFrag.show(thisFrag, "dialog")
            }
        }
    }


//    override fun onBackPressed()
//    {
//        super.onBackPressed()
//        itemModel.save()
//    }
}
