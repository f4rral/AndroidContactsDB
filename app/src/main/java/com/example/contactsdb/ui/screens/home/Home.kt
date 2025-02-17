package com.example.contactsdb.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.Contact
import com.example.contactsdb.ui.contact.ContactList
import com.example.contactsdb.ui.contact.ContactUI
import com.example.contactsdb.viewmodels.ContactsViewModel
import com.example.contactsdb.viewmodels.ContactsViewModelFactory

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val vmContacts: ContactsViewModel = viewModel(
        factory = ContactsViewModelFactory()
    )
    val contactList = vmContacts.contactList.collectAsState(initial = emptyList()).value

    HomeBody(
        contactList,
    )
}

@Composable
fun HomeBody(
    contactList: List<Contact>,
    title: String = "HomeBody",
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = title,
            fontSize = 26.sp
        )

        Button(
            onClick = { ContactsApplication.context.navController.navigate("contact_create") }
        ) {
            Text(
                text = "Создать"
            )
        }

        ContactList(
            contactList = contactList,
            onClickItem = { id: Int ->
                ContactsApplication.context.navController.navigate("contact_detail/$id")
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
        title = "HomeScreenPreview",
    )
}