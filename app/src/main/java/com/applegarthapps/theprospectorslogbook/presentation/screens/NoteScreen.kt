package com.applegarthapps.theprospectorslogbook.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PictureInPicture
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.applegarthapps.theprospectorslogbook.data.model.Note
import com.applegarthapps.theprospectorslogbook.presentation.components.NoteInputText
import com.applegarthapps.theprospectorslogbook.presentation.components.NoteRow

@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
    onEditNote: (Note) -> Unit
) {
    val textState = remember {
        mutableStateOf(TextFieldValue)
    }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    val context = LocalContext.current
    //val localContext = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp)
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = com.applegarthapps.theprospectorslogbook.R.string.app_name))
            },
            backgroundColor = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = stringResource(com.applegarthapps.theprospectorslogbook.R.string.add_a_new_prospect))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "Latitude: ")
                Text(text = "Longitude: ")
            }

        }
        Divider(
            color = MaterialTheme.colors.primary,
            thickness = 2.dp
        )
        NoteInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 6.dp)
                .padding(6.dp),
            text = title,
            label = stringResource(com.applegarthapps.theprospectorslogbook.R.string.title_of_prospect),
            onTextChange = {
                title = it
            }
        )
        NoteInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp, start = 6.dp, end = 12.dp),
            text = description,
            label = stringResource(com.applegarthapps.theprospectorslogbook.R.string.describe_the_prospect),
            onTextChange = {
                description = it
            },
        )
        NoteInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp, end = 12.dp),
            text = latitude,
            label = stringResource(com.applegarthapps.theprospectorslogbook.R.string.latitude),
            onTextChange = {
                latitude = it
            },
        )
        NoteInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp, end = 12.dp),
            text = longitude,
            label = stringResource(com.applegarthapps.theprospectorslogbook.R.string.longitude),
            onTextChange = {
                longitude = it
            },
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                imageVector = Icons.Default.Save,
                contentDescription = stringResource(com.applegarthapps.theprospectorslogbook.R.string.save_icon),
                modifier = Modifier
                    .clickable {
                        if (title.isNotEmpty() && description.isNotEmpty()
                            && latitude.isNotEmpty() && longitude.isNotEmpty()
                        ) {
                            onAddNote(
                                Note(
                                    title = title,
                                    description = description,
                                    latitude = latitude,
                                    longitude = longitude
                                )
                            )
                            title = ""
                            description = ""
                            latitude = ""
                            longitude = ""
                            Toast.makeText(
                                context, "Your $title, " +
                                        "$description, " +
                                        "$latitude and " +
                                        "$longitude was added",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            )
            Text(
                text = stringResource(com.applegarthapps.theprospectorslogbook.R.string.add_a_picture),
                modifier = Modifier
                    .padding(end = 48.dp)
                    .width(200.dp),
                textAlign = TextAlign.End
            )
            Icon(
                imageVector = Icons.Default.PictureInPicture,
                contentDescription = stringResource(com.applegarthapps.theprospectorslogbook.R.string.add_picture),
                modifier = Modifier
                    .clickable {
                    }
            )
        }
        Divider(color = MaterialTheme.colors.primary, thickness = 2.dp)
        Spacer(modifier = Modifier.height(6.dp))
        LazyColumn {
            items(notes) { note ->
                NoteRow(
                    note = note,
                    onNoteClicked = {
                        onRemoveNote(note)
                    },
                    onEditNoteClicked = {
                        onEditNote(
                            Note(
                                title = title + textState.value.toString(),
                                description = description + textState.value.toString(),
                                latitude = latitude + textState.value.toString(),
                                longitude = longitude + textState.value.toString()
                            )
                        )
                        title = ""
                        description = ""
                        Toast.makeText(context, "Your text was edited", Toast.LENGTH_SHORT).show()


                    }

                )


            }
        }
    }
}


