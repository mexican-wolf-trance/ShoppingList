package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import edu.charles_wyatt.shoppinglist.database.ShoppingListDatabase
import edu.charles_wyatt.shoppinglist.database.list.ShoppingListRepo
import kotlinx.coroutines.runBlocking


class ShoppingViewModel(application: Application) : AndroidViewModel(application)
{
    val lists: LiveData<List<ShoppingList>>

    var list: ShoppingList =
        ShoppingList()
        private set

    private var listRepo: ShoppingListRepo

    init
    {
        val dao = ShoppingListDatabase.get(application).shoppingListDao()
        listRepo =
            ShoppingListRepo(dao)
        this.lists = listRepo.lists
    }

    fun save()
    {
        if (list.listName.isNotEmpty())
        {
            runBlocking {
                listRepo.insert(this@ShoppingViewModel.list)
            }
        }
    }
}