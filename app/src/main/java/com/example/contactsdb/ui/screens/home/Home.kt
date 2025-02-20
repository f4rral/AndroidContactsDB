package com.example.contactsdb.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.Contact
import com.example.contactsdb.ui.contact.ContactList
import com.example.contactsdb.ui.contact.ContactUI
import com.example.contactsdb.viewmodels.ContactsVM
import com.example.contactsdb.viewmodels.ContactsVMFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val vmContacts: ContactsVM = viewModel(
        factory = ContactsVMFactory()
    )
    val contactList = vmContacts.contactList.collectAsState(initial = emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = "TopAppBar")
                }
            )
        },
//        bottomBar = {
//            BottomAppBar {
//                Text(text = "BottomAppBar")
//            }
//        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { ContactsApplication.context.navController.navigate("contact_create") }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        modifier = Modifier.windowInsetsPadding(
            insets = WindowInsets.systemBars
        ),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            HomeBody(
                contactList,
            )
        }
    }
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
        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 26.sp,
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

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