package com.example.contactsdb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            HomeScreen(
                navController = navController
            )
        }

        composable(route = "contact_detail") {
            ContactDetailScreen()
        }
    }
}