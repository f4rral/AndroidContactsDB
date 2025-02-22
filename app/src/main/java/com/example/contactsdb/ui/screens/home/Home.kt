package com.example.contactsdb.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.Contact
import com.example.contactsdb.navigation.NavigationRoute
import com.example.contactsdb.ui.contact.ContactList
import com.example.contactsdb.ui.contact.ContactUI
import com.example.contactsdb.ui.screens.layouts.ScreenLayout
import com.example.contactsdb.viewmodels.ContactsVM
import com.example.contactsdb.viewmodels.ContactsVMFactory


@Composable
fun HomeScreen() {
    val vmContacts: ContactsVM = viewModel(
        factory = ContactsVMFactory()
    )
    val contactList = vmContacts.contactList.collectAsState(initial = emptyList()).value

    ScreenLayout(
        title = "Home",
        onFloatingActionButton = {
            ContactsApplication.context.navController.navigate(
                route = NavigationRoute.contactCreate
            )
        }
    ) {
        HomeBody(
            contactList = contactList,
        )
    }
}

@Composable
fun HomeBody(
    contactList: List<Contact>,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ContactList(
            contactList = contactList,
            onClickItem = { id: Int ->
                ContactsApplication.context.navController.navigate(
                    route = "${NavigationRoute.contactDetail}/$id"
                )
                Toast.makeText(context, "onClick ContactItem $id", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeBody(
        contactList = ContactUI.previewContactData,
    )
}