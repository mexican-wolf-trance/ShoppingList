package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import edu.charles_wyatt.shoppinglist.database.ShoppingList
import edu.charles_wyatt.shoppinglist.database.ShoppingListDatabase
import edu.charles_wyatt.shoppinglist.database.ShoppingListRepo
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.runBlocking
import java.util.*

@InternalCoroutinesApi
class CreateListViewModel(application: Application): AndroidViewModel(application)
{
    var list: ShoppingList = ShoppingList()
    private set

    private var listRepo: ShoppingListRepo

    init
    {
        val dao = ShoppingListDatabase.get(application).shoppingListDao()
        listRepo = ShoppingListRepo(dao)
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