package edu.charles_wyatt.shoppinglist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.charles_wyatt.shoppinglist.database.list.ShoppingList
import edu.charles_wyatt.shoppinglist.database.list.ShoppingListDao


@Database(entities = [ShoppingList::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class ShoppingListDatabase: RoomDatabase()
{
    abstract fun shoppingListDao(): ShoppingListDao

    companion object
    {
        private var INSTANCE: ShoppingListDatabase? = null


        fun get(context: Context): ShoppingListDatabase
        {
            val currentInstance =
                INSTANCE
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