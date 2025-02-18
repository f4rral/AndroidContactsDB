package com.example.contactsdb.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.Contact
import com.example.contactsdb.data.ContactDao
import com.example.contactsdb.data.ContactDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class ContactDetailVM(
    private val contactDao: ContactDao,
    contactId: Int
) : ViewModel() {

    val contact: StateFlow<Contact> = contactDao.getContactById(contactId)
        .filterNotNull()
        .map {
            Contact(id = it.id, name = it.name, email = it.email)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = Contact(null, "", "")
        )

    fun delete() {
        viewModelScope.launch {
            contactDao.delete(contact.value)
        }
    }
}

class ContactDetailVMFactory(
    private val contactId: Int = -1
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: KClass<T>,
        extras: CreationExtras
    ): T {
        val database: ContactDatabase = (extras[APPLICATION_KEY] as ContactsApplication).database

        return ContactDetailVM(database.contactDao, contactId) as T
    }
}