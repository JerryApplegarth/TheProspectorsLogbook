package com.applegarthapps.theprospectorslogbook.presentation.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import com.applegarthapps.theprospectorslogbook.presentation.ui.theme.cardBackground

@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,

    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val focusManager = LocalFocusManager.current

    TextField(


        value = text,
        onValueChange = onTextChange,
        label = { Text(text = label) },

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.cardBackground,

            ),

        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone =  {
            onImeAction()
            focusManager.clearFocus()
        }),
        modifier = modifier

    )

}