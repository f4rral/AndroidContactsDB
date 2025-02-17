package com.example.contactsdb.ui.screens.contact_create

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@SuppressLint("UnrememberedMutableState")
@Composable
fun ContactCreate() {
    val textField1 = remember { mutableStateOf("textField1") }
    val textField2 = remember { mutableStateOf("textField2") }

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
            value = textField1.value,
            onValueChange = { textField1.value = it },
            label = {
                Text(
                    text = "textField1"
                )
            }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = textField2.value,
            onValueChange = { textField2.value = it },
            label = {
                Text(
                    text = "textField2"
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCreatePreview() {
    ContactCreate()
}