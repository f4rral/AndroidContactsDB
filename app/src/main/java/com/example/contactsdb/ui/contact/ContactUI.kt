package com.example.contactsdb.ui.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactsdb.data.Contact
import com.example.contactsdb.ui.theme.ContactsDBTheme


class ContactUI {
    companion object {
        val previewContactData = listOf(
            Contact(id = 0, name = "name0", email = "email0@mail.ru"),
            Contact(id = 1, name = "name1", email = "email1@mail.ru"),
            Contact(id = 2, name = "name2", email = "email2@mail.ru")
        )
    }
}

@Composable
fun ContactItem(
    item: Contact = Contact(id = 0, name = "name", email = "e-mail")
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = item.id.toString())
            Text(text = item.name)
            Text(text = item.email)
        }
    }
}

@Composable
fun ContactList(contactList: List<Contact> = ContactUI.previewContactData) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(contactList) {
            ContactItem(item = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactListPreview() {
    ContactsDBTheme {
        ContactList(
            contactList = ContactUI.previewContactData
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactItemPreview() {
    ContactsDBTheme {
        ContactItem(item = ContactUI.previewContactData[0])
    }
}