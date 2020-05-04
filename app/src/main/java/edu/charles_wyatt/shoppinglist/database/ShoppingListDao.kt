package edu.charles_wyatt.shoppinglist.database

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface ShoppingListDao
{
    @Query("SELECT * FROM shopping ORDEr BY id ASC")
    suspend fun allLists(): LiveData<List<ShoppingList>>

    @Query("SELECT * FROM shopping WHERE id = :id LIMIT 1")
    suspend fun forID(id: UUID): ShoppingList?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(list: ShoppingList)

    @Delete
    suspend fun delete(list: ShoppingList)
}