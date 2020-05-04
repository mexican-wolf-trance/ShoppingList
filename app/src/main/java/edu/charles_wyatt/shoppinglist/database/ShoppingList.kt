package edu.charles_wyatt.shoppinglist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "shopping")
class ShoppingList(
    @PrimaryKey var id: UUID = UUID.randomUUID()) {
    @ColumnInfo var listName: String = ""
    @ColumnInfo var item: String = ""
    @ColumnInfo var price: Double = 0.0
    @ColumnInfo var isBought: Boolean = false
}