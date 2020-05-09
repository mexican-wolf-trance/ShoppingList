package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import edu.charles_wyatt.shoppinglist.database.ShoppingListDatabase
import edu.charles_wyatt.shoppinglist.database.listItems.Item
import edu.charles_wyatt.shoppinglist.database.listItems.ItemRepo
import kotlinx.coroutines.runBlocking
import java.util.*


class CreateListViewModel(application: Application): AndroidViewModel(application)
{

    private lateinit var listId: UUID

    fun setListId(id: UUID)
    { listId = id }

//    fun getListId(listId: UUID) = listId

    var items: LiveData<List<Item>>

    var item: Item = Item(listId)
    private set

    private var itemRepo: ItemRepo

    init
    {
        val dao = ShoppingListDatabase.get(application).itemDao()
        itemRepo = ItemRepo(dao)
        this.items = itemRepo.items
    }

    fun loadList(listId: UUID)
    {
        runBlocking {
            itemRepo.getItems(listId)?.let {fetchedList ->
                this@CreateListViewModel.items = fetchedList
            }
        }
    }

    fun save()
    {
        if (item.name.isNotEmpty())
        {
            runBlocking {
                itemRepo.insert(this@CreateListViewModel.item)
            }
        }
    }

}