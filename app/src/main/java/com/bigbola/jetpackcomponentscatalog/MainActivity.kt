package com.bigbola.jetpackcomponentscatalog

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bigbola.jetpackcomponentscatalog.ui.theme.AdvanceSlider
import com.bigbola.jetpackcomponentscatalog.ui.theme.BasicSlider
import com.bigbola.jetpackcomponentscatalog.ui.theme.CheckInfo
import com.bigbola.jetpackcomponentscatalog.ui.theme.JetpackcomponentscatalogTheme
import com.bigbola.jetpackcomponentscatalog.ui.theme.MyDialog
import com.bigbola.jetpackcomponentscatalog.ui.theme.MyRangeSlider
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomponentscatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    var myText by remember { mutableStateOf("") }
//                    MyTextField(myText) { myText = it}

//                    MyProgresAdvance()

//                    var status by rememberSaveable { mutableStateOf(false) }
//                    val checkInfo = CheckInfo(
//                        title = "Ejemplo 1",
//                        selected = status,
//                        onCheckedChange = { status = it })

                    val myOptions = getOptiond(listOf("Llule", "LLH", "LL", "Ejemplo"))

                    Column {


//                        MyBadgBox()
//                        MyDivider()
//                        MyDropDownMenu()
                        var show by remember { mutableStateOf(false) }
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Button(onClick = { show = true }) {
                                Text(text = "Mostrar dialogo")

                            }
                            MyDialog(
                                show = show,
                                onDismiss = { show = false },
                                onConfirm = { Log.i("llh", "click") })
                        }

//                        -------------
//                        var selected by remember { mutableStateOf("Llule") }
//                        MyRadioButtonList(selected){ selected=it}
//                        -------------

//                        ----------
//                        MyTriStatusCheckBox()
//                        myOptions.forEach {
//                            MyCheckBoxWithTextCompleted(it)
//                        }
//                        send(myOptions)

//                        MyCheckBoxWithText("Opcion2")
//                        ----------
                    }


                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackcomponentscatalogTheme {
        MyDropDownMenu()
    }
}

@Composable
fun getOptiond(title: List<String>): List<CheckInfo> {
    return title.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus })
    }
}


@Composable
fun MyProgresAdvance() {

    var progressStatus by remember { mutableStateOf(0f) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus)

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { progressStatus += 0.1f }, Modifier.padding(10.dp)) {
                Text(text = "Incrementar")
            }

            Button(onClick = { progressStatus -= 0.1f }, Modifier.padding(10.dp)) {
                Text(text = "Reducir")
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natillas", "Chilaquiles")

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {

            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = { Text(dessert) },
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    })
            }
        }

    }
}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), color = Color.Red
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgBox() {
    Column(modifier = Modifier.padding(16.dp)) {
        BadgedBox(badge = {
            Badge(
                containerColor = Color.Green,
                contentColor = Color.Blue
            ) { Text("118") }
        }, Modifier.padding(16.dp)) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
        }
    }
}


@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(Color.Green),
        border = BorderStroke(5.dp, Color.Red)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1", color = Color.Black)
            Text(text = "Ejemplo 2", color = Color.Red)
            Text(text = "Ejemplo 3")
        }

    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

//    var selected by remember { mutableStateOf("Llule") }

    Column(Modifier.fillMaxWidth()) {

        Row(modifier = Modifier.fillMaxWidth()) {
//            RadioButton( selected = selected == "Llule", onClick = { selected = "Llule" } )
            RadioButton(selected = name == "Llule", onClick = { onItemSelected("Llule") })
            Text(text = "Llule", Modifier.padding(10.dp))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
//            RadioButton( selected = selected == "Luis", onClick = { selected = "Luis" } )
            RadioButton(selected = name == "Luis", onClick = { onItemSelected("Luis") })
            Text(text = "Luis", Modifier.padding(10.dp))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
//            RadioButton( selected = selected == "Pepe", onClick = { selected = "Pepe" } )
            RadioButton(selected = name == "Pepe", onClick = { onItemSelected("Pepe") })
            Text(text = "Pepe", Modifier.padding(10.dp))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
//            RadioButton( selected = selected == "Aris", onClick = { selected = "Aris" } )
            RadioButton(selected = name == "Aris", onClick = { onItemSelected("Aris") })
            Text(text = "Aris", Modifier.padding(10.dp))
        }

    }
}

@Composable
fun MyRadioButton() {
    Row(modifier = Modifier.fillMaxWidth()) {

        RadioButton(
            selected = true,
            onClick = { /*TODO*/ },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Green
            )
        )

        Text(text = "Ejemplo 1", Modifier.padding(10.dp))
    }

}


@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
            enabled = true,
//            colors = CheckboxDefaults.colors(
//                checkedColor = Color.Green,
//                uncheckedColor = Color.Gray,
//                checkmarkColor = Color.Yellow
//            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }


}

@Composable
fun send(myListOptions: List<CheckInfo>) {


    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = {
            myListOptions.forEach {
                Log.i("check", "${it.title} is Selected :${it.selected}")
            }
        }, Modifier.padding(10.dp)) {
            Text(text = "States")
        }


    }
}


@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })

}

@Composable
fun MyCheckBoxWithText(text: String) {
    var state by rememberSaveable { mutableStateOf(false) }


    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.Yellow
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }


}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }


    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.Yellow
            )
        )
    }

}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }


    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Gray,
                checkedThumbColor = Color.Green,
                checkedTrackColor = Color.Blue
            )
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = {
        myText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = { Text(text = "Introduce tu nombre") })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {

    var myText by remember { mutableStateOf("") }
    OutlinedTextField(value = myText, onValueChange = { myText = it })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(name: String, onValueChange: (String) -> Unit) {

    TextField(value = name, onValueChange = { onValueChange(it) })
}


@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo ")
        Text(text = "Esto es un ejemplo ", color = Color.Blue)
        Text(text = "Esto es un ejemplo ", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo ", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo ", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo ",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo ",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo ", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline, TextDecoration.LineThrough
                    )
                )
            )
        )
        Text(text = "Esto es un ejemplo ", fontSize = 40.sp)


    }

}