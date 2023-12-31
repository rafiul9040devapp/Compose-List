package com.rafiul.composelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rafiul.composelist.composable.ComponentsOfList
import com.rafiul.composelist.ui.theme.ComposeListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          MyApp {
              NameList()
          }
        }
    }
}

@Composable
fun MyApp( content: @Composable () -> Unit){
    ComposeListTheme {
        content()
    }
}

@Composable
fun NameList(){
    var name by remember {
        mutableStateOf("")
    }
    val names = remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.padding(all = 4.dp),
                onClick = {
                    if (name.isNotBlank()) {
                        names.value += name
                        name = ""
                    }
                },
            ) {
                Text(text = "ADD")
            }
        }

        ComponentsOfList(nameList = names) { deleteName ->
            names.value = names.value.filterNot { it == deleteName }
        }


    }
}



