package edu.charles_wyatt.shoppinglist.database.list

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import java.util.*

@Dao
interface ShoppingListDao
{
    @Query("SELECT * FROM list ORDER BY id ASC")
    fun allLists(): LiveData<List<ShoppingList>>

    @Query("SELECT * FROM list WHERE id = :id LIMIT 1")
    suspend fun forID(id: UUID): ShoppingList?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list: ShoppingList)

    @Delete
    suspend fun delete(list: ShoppingList)
}