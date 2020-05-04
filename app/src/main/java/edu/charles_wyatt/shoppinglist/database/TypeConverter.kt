package edu.charles_wyatt.shoppinglist.database

import androidx.room.TypeConverter
import java.util.*

class TypeConverter
{
    @TypeConverter
    fun fromString(uuidString: String): UUID? = UUID.fromString(uuidString)

    @TypeConverter
    fun uuidToString(uuid: UUID): String = uuid.toString()
}