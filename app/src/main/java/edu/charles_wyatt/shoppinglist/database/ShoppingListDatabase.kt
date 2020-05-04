package edu.charles_wyatt.shoppinglist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [ShoppingList::class], version = 1)
abstract class ShoppingListDatabase: RoomDatabase()
{
    abstract fun shoppingListDao(): ShoppingListDao

    companion object
    {
        private var INSTANCE: ShoppingListDatabase? = null


        @InternalCoroutinesApi
        fun get(context: Context): ShoppingListDatabase
        {
            val currentInstance = INSTANCE
            if (currentInstance != null)
                return currentInstance

            synchronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext, ShoppingListDatabase::class.java, "shoppinglistDb.sqlite")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}