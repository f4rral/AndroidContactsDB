package com.example.contactsdb.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.Contact
import com.example.contactsdb.data.ContactDao
import com.example.contactsdb.data.ContactDatabase
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class ContactCreateVM(private val contactDao: ContactDao) : ViewModel() {
    var name = mutableStateOf("")
    var email = mutableStateOf("")

    fun createContact() {
        viewModelScope.launch {
            contactDao.insert(
                Contact(
                    name = name.value,
                    email = email.value,
                )
            )
        }
    }
}

class ContactCreateVMFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: KClass<T>,
        extras: CreationExtras
    ): T {
        val database: ContactDatabase = (extras[APPLICATION_KEY] as ContactsApplication).database

        return ContactCreateVM(database.contactDao) as T
    }
}