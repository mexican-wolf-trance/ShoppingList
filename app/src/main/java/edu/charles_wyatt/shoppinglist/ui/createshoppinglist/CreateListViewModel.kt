package edu.charles_wyatt.shoppinglist.ui.createshoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import edu.charles_wyatt.shoppinglist.database.ShoppingListDatabase
import edu.charles_wyatt.shoppinglist.database.listItems.Item
import edu.charles_wyatt.shoppinglist.database.listItems.ItemRepo
import kotlinx.coroutines.runBlocking
import java.util.*


class CreateListViewModel(application: Application): AndroidViewModel(application)
{

    lateinit var listId: UUID
    private set

//    fun setListId(id: UUID)
//    { this.listId = id }

//    fun getListId(listId: UUID) = listId

    private val _items = MutableLiveData<List<Item>>()
    var items = Transformations.map(_items){ it }

    var item: Item? = null
    private set

    private var itemRepo: ItemRepo

    init
    {
        val dao = ShoppingListDatabase.get(application).itemDao()
        itemRepo = ItemRepo(dao)
//        this.items = itemRepo.getItems(listId)
    }

    fun loadList(listId: UUID)
    {
        this.listId = listId
        runBlocking {
            itemRepo.getItems(listId).let { fetchedList ->
                this@CreateListViewModel.items = fetchedList
            }
        }
    }

    private fun save(item: Item)
    {
        if (item.name.isNotEmpty())
            {
                runBlocking {
                    itemRepo.insert(item)
                }
            }
    }

    fun createItemWith(name: String, price: Double)
    {
        val item = Item(listId = listId)
        item.name = name
        item.price = price
        this.save(item)
    }

    fun deleteItemAtIndex(id: UUID)
    {
        runBlocking {
            itemRepo.delete(itemId = id)
        }
    }

}