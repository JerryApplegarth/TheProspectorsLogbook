package com.applegarthapps.theprospectorslogbook.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applegarthapps.theprospectorslogbook.R
import com.applegarthapps.theprospectorslogbook.data.model.Note
import com.applegarthapps.theprospectorslogbook.presentation.ui.theme.cardBackground
import com.applegarthapps.theprospectorslogbook.presentation.utils.formatDate

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit,
    onEditNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth(),
        color = MaterialTheme.colors.cardBackground,
        elevation = 6.dp
    ) {
        Column(
            modifier
                .padding(
                    horizontal = 14.dp,
                    vertical = 6.dp
                ),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = note.description,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = note.latitude,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = note.longitude,
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.caption
            )
            Row(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "Edit",
                    modifier = Modifier

                        .clickable {
                            onEditNoteClicked(note)
                        }
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete",
                    modifier = Modifier

                        .clickable {
                            onNoteClicked(note)
                        }
                )
            }

        }
    }
}
