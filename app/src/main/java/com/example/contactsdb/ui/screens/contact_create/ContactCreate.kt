package com.example.contactsdb.ui.screens.contact_create

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.navigation.NavigationRoute
import com.example.contactsdb.ui.screens.layouts.ScreenLayout
import com.example.contactsdb.viewmodels.ContactCreateVM
import com.example.contactsdb.viewmodels.ContactCreateVMFactory


@Composable
fun ContactCreate() {
    val vm: ContactCreateVM = viewModel(
        factory = ContactCreateVMFactory()
    )

    val context = LocalContext.current

    ScreenLayout(
        title = "ContactCreate"
    ) {
        OutlinedTextField(
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

        OutlinedTextField(
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
                ContactsApplication.context.navController.navigate(
                    route = NavigationRoute.home
                )
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