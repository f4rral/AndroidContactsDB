package com.example.contactsdb.ui.screens.contact_create

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.viewmodels.ContactCreateViewModel
import com.example.contactsdb.viewmodels.ContactCreateViewModelFactory

@SuppressLint("UnrememberedMutableState")
@Composable
fun ContactCreate() {
    val vm: ContactCreateViewModel = viewModel(
        factory = ContactCreateViewModelFactory()
    )

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "ContactCreate",
            fontSize = 26.sp
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = vm.name.value,
            onValueChange = { vm.name.value = it },
            label = {
                Text(
                    text = "Имя"
                )
            }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = vm.email.value,
            onValueChange = { vm.email.value = it },
            label = {
                Text(
                    text = "E-mail"
                )
            }
        )

        Button(
            onClick = {
                Toast.makeText(context, "onClick add contact", Toast.LENGTH_SHORT).show()
                vm.createContact()
            }
        ) {
            Text(
                text = "Добавить"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCreatePreview() {
    ContactCreate()
}