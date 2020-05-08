package edu.charles_wyatt.shoppinglist.database.list

import androidx.lifecycle.LiveData
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import edu.charles_wyatt.shoppinglist.database.list.ShoppingListDao
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