package com.bigbola.jetpackcomponentscatalog.ui.theme

class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)