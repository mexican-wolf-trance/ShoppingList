package edu.charles_wyatt.shoppinglist.database.listItems

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.*

interface ItemDao
{
    @Query("SELECT * FROM item WHERE list_Id = :listId ORDER BY name")
    fun getItems(listId: UUID): LiveData<List<Item>>

    @Query("SELECT * FROM item WHERE id = :itemId AND list_id = :listId")
    fun getItem(itemId: UUID, listId: UUID): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: UUID)
}