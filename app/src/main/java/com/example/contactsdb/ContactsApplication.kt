package com.example.contactsdb

import android.app.Application
import androidx.navigation.NavHostController
import com.example.contactsdb.data.ContactDatabase

class ContactsApplication : Application() {
    val database by lazy {
        ContactDatabase.createDatabase(this)
    }

    lateinit var navController: NavHostController

    companion object {
        lateinit var context: ContactsApplication
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}