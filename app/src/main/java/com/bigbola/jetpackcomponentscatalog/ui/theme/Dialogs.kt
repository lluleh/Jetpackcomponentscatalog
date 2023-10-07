package com.bigbola.jetpackcomponentscatalog.ui.theme

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(show:Boolean,
             onDismiss: () -> Unit,
             onConfirm: () -> Unit
) {

    if (show)
    {
        AlertDialog(onDismissRequest = { /*TODO*/ },
            confirmButton = {
                TextButton(onClick = { onConfirm }) {
                    Text(text = "ConfirmButton")

                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss }) {
                    Text(text = "DismissButton")

                }
            },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola, soy una descripcion super :()") })
    }
}