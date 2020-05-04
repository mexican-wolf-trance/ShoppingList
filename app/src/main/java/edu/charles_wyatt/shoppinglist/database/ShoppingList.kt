package edu.charles_wyatt.shoppinglist.database

import java.util.*

data class ShoppingList(val id: UUID = UUID.randomUUID())
{
    var itemName: String? = null
    var itemPrice: String? = null
    var isBought: Boolean = false
}