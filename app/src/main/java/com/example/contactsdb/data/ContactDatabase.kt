package com.example.contactsdb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Contact::class],
    version = 1,
    exportSchema = false
)
abstract class ContactDatabase : RoomDatabase() {
    abstract var contactDao: ContactDao

    companion object {
        fun createDatabase(context: Context) : ContactDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = ContactDatabase::class.java,
                name = "app.dp"
            ).build()
        }
    }
}