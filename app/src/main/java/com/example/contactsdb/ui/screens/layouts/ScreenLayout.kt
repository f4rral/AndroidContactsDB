package com.example.contactsdb.ui.screens.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactsdb.ui.theme.ThemeColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLayout(
    title: String = "TopAppBar",
    onNavBack: (() -> Unit)? = null,
    onFloatingActionButton: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .windowInsetsPadding(
                insets = WindowInsets.systemBars
            ),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = ThemeColor.gray2,
                    titleContentColor = ThemeColor.gray7,
                ),

                title = {
                    Text(
                        text = title,
                    )
                },

                navigationIcon = {
                    if (onNavBack != null) {
                        IconButton(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            onClick = {
                                onNavBack()
                            }

                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            if (onFloatingActionButton != null) {
                FloatingActionButton(
                    onClick = {
                        onFloatingActionButton()
                    }
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add"
                    )
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(ThemeColor.gray4)
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun ScreenLayoutPreview() {
    ScreenLayout {}
}
