package com.example.contactsdb.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("DELETE FROM contact WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAll(): Flow<List<Contact>>

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getContactById(id: Int): Flow<Contact?>
}