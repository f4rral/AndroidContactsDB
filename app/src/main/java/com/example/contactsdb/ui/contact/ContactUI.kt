package com.example.contactsdb.ui.contact

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.Contact
import com.example.contactsdb.navigation.NavigationRoute
import com.example.contactsdb.ui.theme.ContactsDBTheme
import com.example.contactsdb.ui.theme.ThemeColor


class ContactUI {
    companion object {
        val previewContactData = listOf(
            Contact(id = 0, name = "Jerome Bell", email = "@whitefish664"),
            Contact(id = 1, name = "Jerome Bell", email = "@whitefish664"),
            Contact(id = 2, name = "Jerome Bell", email = "@whitefish664")
        )
    }
}

@Composable
fun ContactItem(
    item: Contact = Contact(id = null, name = "name", email = "e-mail"),
    onClick: ((id: Int) -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = ThemeColor.gray2,
        ),
        onClick = {
            if (onClick != null) {
                onClick(item.id!!)
            }
        }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(IntrinsicSize.Max)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 48.dp, height = 48.dp)
                    .clip(shape = RoundedCornerShape(percent = 50))
                    .background(ThemeColor.violet3)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()

            ) {
                Text(
                    text = item.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 19.sp,
                    color = ThemeColor.gray7,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = item.email,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 17.sp,
                    color = ThemeColor.gray5
                )
            }
        }
    }
}

@Composable
fun ContactDetail(
    item: Contact,
    onDelete: (() -> Unit)? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .background(ThemeColor.gray2)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clip(shape = RoundedCornerShape(percent = 50))
                .size(width = 64.dp, height = 64.dp)
                .background(ThemeColor.violet3)
        )

        Text(
            text = item.name,
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = ThemeColor.gray7,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        Text(
            text = item.name,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = ThemeColor.gray5,
        )

        Button(
            colors = ButtonColors(
                contentColor = ThemeColor.gray2,
                containerColor = ThemeColor.violet3,
                disabledContentColor = ThemeColor.gray4,
                disabledContainerColor = ThemeColor.gray5
            ),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(12.dp),
            onClick = {
                if (onDelete != null) {
                    onDelete()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Удалить",
                fontSize = 16.sp,
                fontWeight = FontWeight(600)
            )
        }
    }
}

@Composable
fun ContactCreate(
    name: String = "",
    email: String = "",
    onChangeName: ((value: String) -> Unit)? = null,
    onChangeEmail: ((value: String) -> Unit)? = null,
    onCreate: (() -> Unit)? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .background(ThemeColor.gray2)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                if (onChangeName != null) {
                    onChangeName(it)
                }
            },
            label = {
                Text(
                    text = "Имя"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                if (onChangeEmail != null) {
                    onChangeEmail(it)
                }
            },
            label = {
                Text(
                    text = "E-mail"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(
            colors = ButtonColors(
                contentColor = ThemeColor.gray2,
                containerColor = ThemeColor.violet3,
                disabledContentColor = ThemeColor.gray4,
                disabledContainerColor = ThemeColor.gray5
            ),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(12.dp),
            onClick = {
                if (onCreate != null) {
                    onCreate()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Создать",
                fontSize = 16.sp,
                fontWeight = FontWeight(600)
            )
        }
    }
}

@Composable
fun ContactList(
    contactList: List<Contact> = ContactUI.previewContactData,
    onClickItem: ((id: Int) -> Unit)? = null
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(contactList) {
            ContactItem(
                item = it,
                onClick = onClickItem
            )
        }
    }
}

@Preview
@Composable
private fun ContactListPreview() {
    ContactsDBTheme {
        ContactList(
            contactList = ContactUI.previewContactData
        )
    }
}

@Preview
@Composable
private fun ContactItemPreview() {
    ContactsDBTheme {
        ContactItem(item = ContactUI.previewContactData[0])
    }
}

@Preview
@Composable
private fun ContactDetailPreview() {
    ContactsDBTheme {
        ContactDetail(item = ContactUI.previewContactData[0])
    }
}

@Preview
@Composable
fun ContactCreatePreview() {
    ContactsDBTheme {
        ContactCreate(
            name = "name",
            email = "email"
        )
    }
}