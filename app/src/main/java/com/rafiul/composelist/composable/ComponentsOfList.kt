package com.rafiul.composelist.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ComponentsOfList(modifier: Modifier = Modifier,nameList: MutableState<List<String>>, onDelete: (String) -> Unit = {}) {

    LazyColumn(modifier) {
        items(nameList.value) { currentName ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                        .weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))

                IconButton(onClick = {
                    onDelete(currentName)
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "",
                        tint = Color.Red
                    )
                }
            }
            Divider()
        }
    }
}



