package com.example.contactsdb.ui.screens.contact_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.viewmodels.ContactDetailViewModel
import com.example.contactsdb.viewmodels.ContactDetailViewModelFactory

@Composable
fun ContactDetailScreen(id: Int) {
    val vmContactDetail: ContactDetailViewModel = viewModel(
        factory = ContactDetailViewModelFactory(id)
    )
    val contact = vmContactDetail.contact.collectAsState(initial = null).value

    Column {
        Text(
            text = "DetailContactScreen",
            fontSize = 26.sp
        )

        Text(
            text = "${contact?.id}, ${contact?.name}, ${contact?.email}",
            fontSize = 22.sp
        )
    }
}