package com.example.contactsdb.ui.screens.contact_detail

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contactsdb.ContactsApplication
import com.example.contactsdb.data.Contact
import com.example.contactsdb.navigation.NavigationRoute
import com.example.contactsdb.ui.contact.ContactDetail
import com.example.contactsdb.ui.contact.ContactUI
import com.example.contactsdb.ui.screens.layouts.ScreenLayout
import com.example.contactsdb.viewmodels.ContactDetailVM
import com.example.contactsdb.viewmodels.ContactDetailVMFactory

@Composable
fun ContactDetailScreen(id: Int) {
    val vmContactDetail: ContactDetailVM = viewModel(
        factory = ContactDetailVMFactory(id)
    )

    val contact = vmContactDetail.contact.collectAsState(initial = null).value
    val context = LocalContext.current

    fun delete() {
        Toast.makeText(context, "onClick delete contact", Toast.LENGTH_SHORT).show()
        ContactsApplication.context.navController.navigate(
            route = NavigationRoute.home
        ) {
            popUpTo(
                route = NavigationRoute.home
            ) {
                inclusive = true
            }
        }

        vmContactDetail.delete()
    }

    ScreenLayout(
        title = "DetailContactScreen",
        onNavBack = {
            ContactsApplication.context.navController.navigate(
                route = NavigationRoute.home
            ) {
                popUpTo(
                    route = NavigationRoute.home
                ) {
                    inclusive = true
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            if (contact != null) {
                ContactDetail(
                    item = contact,
                    onDelete = {
                        delete()
                    }
                )
            }
        }
    }
}

@Composable
fun ContactDetailBody(
    item: Contact,
    onDelete: (() -> Unit)? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        ContactDetail(
            item = item,
            onDelete = {
                if (onDelete != null) {
                    onDelete()
                }
            }
        )
    }
}

@Preview
@Composable
fun ContactDetailBodyPreview() {
    ScreenLayout {
        ContactDetailBody(
            item = ContactUI.previewContactData[0]
        )
    }
}