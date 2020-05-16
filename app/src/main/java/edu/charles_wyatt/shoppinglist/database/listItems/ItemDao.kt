package edu.charles_wyatt.shoppinglist.database.listItems

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface ItemDao
{
    @Query("SELECT * FROM item WHERE list_Id = :listId ORDER BY name")
    fun getItems(listId: UUID): LiveData<List<Item>>

    @Query("SELECT * FROM item WHERE id = :itemId AND list_Id = :listId")
    fun getItem(itemId: UUID, listId: UUID): LiveData<Item>

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun delete(id: UUID)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)
}