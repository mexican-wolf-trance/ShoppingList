package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import edu.charles_wyatt.shoppinglist.database.ShoppingListDatabase
import edu.charles_wyatt.shoppinglist.database.list.ShoppingListRepo
import kotlinx.coroutines.runBlocking
import java.util.*


class CreateListViewModel(application: Application): AndroidViewModel(application)
{
    var list: ShoppingList =
        ShoppingList()
    private set

    val lists: LiveData<List<ShoppingList>>

    private var listRepo: ShoppingListRepo

    init
    {
        val dao = ShoppingListDatabase.get(application).shoppingListDao()
        listRepo =
            ShoppingListRepo(dao)
        this.lists = listRepo.lists
    }

    fun loadList(uuid: UUID)
    {
        runBlocking {
            listRepo.listForId(uuid)?.let {fetchedList ->
                this@CreateListViewModel.list = fetchedList
            }
        }
    }

    fun save()
    {
        if (list.listName.isNotEmpty())
        {
            runBlocking {
                listRepo.insert(this@CreateListViewModel.list)
            }
        }
    }

}