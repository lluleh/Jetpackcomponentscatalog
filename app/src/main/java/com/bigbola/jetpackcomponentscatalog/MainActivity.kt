package com.bigbola.jetpackcomponentscatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bigbola.jetpackcomponentscatalog.ui.theme.CheckInfo
import com.bigbola.jetpackcomponentscatalog.ui.theme.JetpackcomponentscatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomponentscatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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

                        MyTriStatusCheckBox()
                        myOptions.forEach {
                            MyCheckBoxWithTextCompleted(it)
                        }
                        send(myOptions)

//                        MyCheckBoxWithText("Opcion2")
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
        MyTextFieldAdvance()
    }
}

@Composable
fun getOptiond(title: List<String>): List<CheckInfo> {
    return title.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
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







@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(
        Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically,
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
        Button(onClick = { myListOptions.forEach{
            Log.i("check","${it.title} is Selected :${it.selected}")
        }}, Modifier.padding(10.dp)) {
            Text(text = "States")
        }


    }
}


@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
       status = when(status){
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
        Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically,
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

    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") })
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