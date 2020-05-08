package edu.charles_wyatt.shoppinglist.database.list

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "list")
class ShoppingList(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    var listName: String = ""
)