package edu.charles_wyatt.shoppinglist.Persistance.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping")
data class ShoppingListEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val item: String,
    @ColumnInfo val price: Double
)