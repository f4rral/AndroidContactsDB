package com.example.contactsdb.ui.screens.contact_detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun ContactDetailScreen(id: Int?) {
    Text(
        text = "DetailContactScreen $id",
        fontSize = 26.sp
    )
}