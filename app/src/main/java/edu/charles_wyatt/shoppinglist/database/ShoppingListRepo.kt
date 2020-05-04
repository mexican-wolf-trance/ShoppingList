package edu.charles_wyatt.shoppinglist.database

import androidx.lifecycle.LiveData
import java.util.*

class ShoppingListRepo (private val listDao: ShoppingListDao)
{
    val lists: LiveData<List<ShoppingList>> = listDao.allLists()

    suspend fun insert(list: ShoppingList)
    {
        listDao.upsert(list)
    }

    suspend fun listForId(id: UUID): ShoppingList? = listDao.forID(id)
}