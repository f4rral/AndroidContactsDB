package com.example.contactsdb.ui.screens.contact_create

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.navigation.NavigationRoute
import com.example.contactsdb.ui.contact.ContactCreate
import com.example.contactsdb.ui.screens.layouts.ScreenLayout
import com.example.contactsdb.viewmodels.ContactCreateVM
import com.example.contactsdb.viewmodels.ContactCreateVMFactory


@Composable
fun ContactCreateScreen() {
    ScreenLayout(
        title = "ContactCreateScreen",
        onNavBack = {
            ContactsApplication.context.navController.navigate(
                route = NavigationRoute.home
            ) {
                popUpTo(route = NavigationRoute.home) {
                    inclusive = true
                }
            }
        }
    ) {
        ContactCreateBody()
    }
}

@Composable
fun ContactCreateBody() {
    val vm: ContactCreateVM = viewModel(
        factory = ContactCreateVMFactory()
    )

    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        ContactCreate(
            name = vm.name.value,
            email = vm.email.value,
            onChangeName = { vm.name.value = it },
            onChangeEmail = { vm.email.value = it },
            onCreate = {
                Toast.makeText(context, "onClick add contact", Toast.LENGTH_SHORT).show()

                vm.createContact()
                ContactsApplication.context.navController.navigate(
                    route = NavigationRoute.home
                ) {
                    popUpTo( route = NavigationRoute.home ) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCreatePreview() {
    ScreenLayout {
        ContactCreateBody()
    }
}