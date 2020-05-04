package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import edu.charles_wyatt.shoppinglist.database.ShoppingList
import edu.charles_wyatt.shoppinglist.database.ShoppingListDatabase
import edu.charles_wyatt.shoppinglist.database.ShoppingListRepo
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class ShoppingViewModel(application: Application) : AndroidViewModel(application)
{
    val lists: LiveData<List<ShoppingList>>

    init
    {
        val dao = ShoppingListDatabase.get(application).shoppingListDao()
        val repo = ShoppingListRepo(dao)
        this.lists = repo.lists
    }
}