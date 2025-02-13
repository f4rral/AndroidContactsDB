package com.example.contactsdb.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.viewmodels.ContactsViewModel

@Composable
fun HomeScreen() {
    val vmContact: ContactsViewModel = viewModel(factory = ContactsViewModel.factory)
    val contactList = vmContact.contactList.collectAsState(initial = emptyList()).value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "HomeScreen")

        LazyColumn {
            items(contactList) { contact ->
                Text(text = contact.name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}