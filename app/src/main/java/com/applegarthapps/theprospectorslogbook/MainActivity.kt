package com.applegarthapps.theprospectorslogbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applegarthapps.theprospectorslogbook.ui.theme.TheProspectorsLogbookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheProspectorsLogbookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BasicLayout()
                }
            }
        }
    }
}

@Composable
fun BasicLayout() {
    Column(
        modifier = Modifier
            .padding(0.dp)
    ) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .padding(start = 16.dp),
            text = "Text goes here",
            fontSize = 24.sp
            )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier = Modifier
                .padding(start = 16.dp),
            onClick = { /*TODO*/ },

            ) {
            Text(text = "Button")

        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TheProspectorsLogbookTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BasicLayout()
        }

    }
}