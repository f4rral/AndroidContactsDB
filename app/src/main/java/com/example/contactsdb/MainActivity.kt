package com.example.contactsdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.contactsdb.navigation.NavigationGraph
import com.example.contactsdb.ui.theme.ContactsDBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ContactsApplication.context.navController = rememberNavController()

            ContactsDBTheme {
                NavigationGraph(
                    navController = ContactsApplication.context.navController
                )
            }
        }
    }
}
