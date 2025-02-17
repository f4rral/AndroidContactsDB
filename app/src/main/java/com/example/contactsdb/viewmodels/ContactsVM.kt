package com.example.contactsdb.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.ContactDao
import com.example.contactsdb.data.ContactDatabase
import kotlin.reflect.KClass

class ContactsVM(contactDao: ContactDao) : ViewModel() {
    val contactList = contactDao.getAll()
}

class ContactsVMFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: KClass<T>,
        extras: CreationExtras
    ): T {
        val database: ContactDatabase = (extras[APPLICATION_KEY] as ContactsApplication).database

        return ContactsVM(contactDao = database.contactDao) as T
    }
}