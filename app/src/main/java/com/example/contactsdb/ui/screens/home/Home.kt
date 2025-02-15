package com.example.contactsdb.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.data.Contact
import com.example.contactsdb.ui.contact.ContactList
import com.example.contactsdb.ui.contact.ContactUI
import com.example.contactsdb.viewmodels.ContactsViewModel

@Composable
fun HomeScreen() {
    val vmContact: ContactsViewModel = viewModel(factory = ContactsViewModel.factory)
    val contactList = vmContact.contactList.collectAsState(initial = emptyList()).value

    HomeBody(
        contactList
    )
}

@Composable
fun HomeBody(
    contactList: List<Contact>,
    title: String = "HomeBody"
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = title,
            fontSize = 26.sp
        )

        ContactList(
            contactList = contactList
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeBody(
        contactList = ContactUI.previewContactData,
        title = "HomeScreenPreview"
    )
}