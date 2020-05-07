package edu.charles_wyatt.shoppinglist.ui.viewshoppinglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import edu.charles_wyatt.shoppinglist.database.ShoppingList
import edu.charles_wyatt.shoppinglist.database.ShoppingListDatabase
import edu.charles_wyatt.shoppinglist.database.ShoppingListRepo
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.runBlocking


class ShoppingViewModel(application: Application) : AndroidViewModel(application)
{
    val lists: LiveData<List<ShoppingList>>

    var list: ShoppingList = ShoppingList()
        private set

    private var listRepo: ShoppingListRepo

    init
    {
        val dao = ShoppingListDatabase.get(application).shoppingListDao()
        listRepo = ShoppingListRepo(dao)
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