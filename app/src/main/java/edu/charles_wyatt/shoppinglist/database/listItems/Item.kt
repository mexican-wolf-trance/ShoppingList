package edu.charles_wyatt.shoppinglist.database.listItems

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import java.util.*


@Entity(
    tableName = "item",
    foreignKeys = [
       ForeignKey(
           entity = ShoppingList::class,
           parentColumns = ["id"],
           childColumns = ["list_Id"],
           onDelete = ForeignKey.CASCADE
       )
    ]
)
class Item(
    @PrimaryKey var id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "list_Id") val listId: UUID,
    var name: String = "",
    var price: Double = 0.0,
    var isBought: Boolean = false
)
