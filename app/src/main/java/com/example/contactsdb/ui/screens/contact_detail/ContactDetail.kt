package com.example.contactsdb.ui.screens.contact_detail

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.navigation.NavigationRoute
import com.example.contactsdb.ui.screens.layouts.ScreenLayout
import com.example.contactsdb.viewmodels.ContactDetailVM
import com.example.contactsdb.viewmodels.ContactDetailVMFactory

@Composable
fun ContactDetailScreen(id: Int) {
    val vmContactDetail: ContactDetailVM = viewModel(
        factory = ContactDetailVMFactory(id)
    )

    val contact = vmContactDetail.contact.collectAsState(initial = null).value
    val context = LocalContext.current

    ScreenLayout(
        title = "DetailContactScreen",
        onNavBack = {
            ContactsApplication.context.navController.navigate(
                route = NavigationRoute.home
            ) {
                popUpTo(
                    route = NavigationRoute.home
                ) {
                    inclusive = true
                }
            }
        }
    ) {
        Column {
            Text(
                text = "id: ${contact?.id}",
                fontSize = 24.sp
            )

            Text(
                text = "name: ${contact?.name}",
                fontSize = 24.sp
            )

            Text(
                text = "e-mail: ${contact?.email}",
                fontSize = 24.sp
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    Toast.makeText(context, "onClick delete contact", Toast.LENGTH_SHORT).show()
                    ContactsApplication.context.navController.navigate(
                        route = NavigationRoute.home
                    ) {
                        popUpTo(
                            route = NavigationRoute.home
                        ) {
                            inclusive = true
                        }
                    }
                    vmContactDetail.delete()
                }
            ) {
                Text(
                    text = "Удалить",
                    fontSize = 24.sp
                )
            }
        }
    }
}