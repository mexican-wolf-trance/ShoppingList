package edu.charles_wyatt.shoppinglist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping")
data class ShoppingListEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val item: String,
    @ColumnInfo val price: Double
)