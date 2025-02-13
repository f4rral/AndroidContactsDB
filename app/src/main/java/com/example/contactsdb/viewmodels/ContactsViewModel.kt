package com.example.contactsdb.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.ContactDao
import com.example.contactsdb.data.ContactDatabase

class ContactsViewModel(contactDao: ContactDao) : ViewModel() {
    val contactList = contactDao.getAll()

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database: ContactDatabase = (extras[APPLICATION_KEY] as ContactsApplication).database

                return ContactsViewModel(database.contactDao) as T
            }
        }
    }
}