package com.example.contactsdb.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.ContactDao
import com.example.contactsdb.data.ContactDatabase
import kotlin.reflect.KClass

class ContactDetailViewModel(
    contactDao: ContactDao,
    contactId: Int = 1
) : ViewModel() {
    val contact = contactDao.getContactById(contactId)
}

class ContactDetailViewModelFactory(
    private val contactId: Int = -1
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: KClass<T>,
        extras: CreationExtras
    ): T {
        val database: ContactDatabase = (extras[APPLICATION_KEY] as ContactsApplication).database

        return ContactDetailViewModel(database.contactDao, contactId) as T
    }
}