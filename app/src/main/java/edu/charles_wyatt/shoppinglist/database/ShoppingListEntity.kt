package edu.charles_wyatt.shoppinglist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "shopping")
data class ShoppingListEntity(
    @PrimaryKey val id: UUID = UUID.randomUUID()) {
    @ColumnInfo val item: String? = null
    @ColumnInfo val price: Double = 0.0
    @ColumnInfo val isBought: Boolean = false
}