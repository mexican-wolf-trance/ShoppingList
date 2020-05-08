package edu.charles_wyatt.shoppinglist.database.listItems

import java.util.*

class ItemRepo(private val itemDao: ItemDao)
{
    fun getItems(listId: UUID) = itemDao.getItems(listId)

    fun getItem(itemId: UUID, listId: UUID) = itemDao.getItem(itemId, listId)

    suspend fun delete(itemId: UUID) = itemDao.delete(itemId)

    suspend fun insert(item: Item) = itemDao.insert(item)
}