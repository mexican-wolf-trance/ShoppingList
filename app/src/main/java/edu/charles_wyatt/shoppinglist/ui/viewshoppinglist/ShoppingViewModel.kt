package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import androidx.lifecycle.ViewModel
import edu.charles_wyatt.shoppinglist.database.ShoppingList

class ShoppingViewModel : ViewModel()
{
    val lists: List<ShoppingList> = emptyList()
}