package edu.charles_wyatt.shoppinglist.database.listItems

import androidx.lifecycle.LiveData
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import java.util.*

class ItemRepo(private val itemDao: ItemDao)
{
//    val list = LiveData<List<ShoppingList>>

    val items: LiveData<List<Item>> = itemDao.getItems()

    fun getItems(listId: UUID) = itemDao.getItems(listId)

    fun getItem(itemId: UUID, listId: UUID) = itemDao.getItem(itemId, listId)

    suspend fun delete(itemId: UUID) = itemDao.delete(itemId)

    suspend fun insert(item: Item) = itemDao.insert(item)

    suspend fun delete(item: Item) = itemDao.delete(item)
}