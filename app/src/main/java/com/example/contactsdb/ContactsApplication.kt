package com.example.contactsdb

import android.app.Application
import com.example.contactsdb.data.ContactDatabase

class ContactsApplication : Application() {
    val database by lazy {
        ContactDatabase.createDatabase(this)
    }
}