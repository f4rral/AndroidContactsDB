package com.example.contactsdb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.contactsdb.ui.screens.contact_create.ContactCreate
import com.example.contactsdb.ui.screens.contact_detail.ContactDetailScreen
import com.example.contactsdb.ui.screens.home.HomeScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen()
        }

        composable(
            route = "contact_create"
        ) {
            ContactCreate()
        }

        composable(
            route = "contact_detail" + "/{contactId}",
            arguments = listOf(
                navArgument("contactId") {
                    type = NavType.IntType
                }
            )
        ) { stackEntry ->
            val contactId = stackEntry.arguments?.getInt("contactId")

            if (contactId != null) {
                ContactDetailScreen(contactId)
            }
        }
    }
}