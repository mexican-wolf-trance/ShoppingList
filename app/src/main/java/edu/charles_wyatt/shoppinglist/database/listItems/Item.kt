package edu.charles_wyatt.shoppinglist.database.listItems

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "item")
class Item (
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "list_id") val listId: Long,
    @ColumnInfo var name: String,
    @ColumnInfo var price: Double,
    @ColumnInfo var isBought: Boolean
)
