package com.lautung.composedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lautung.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                val stars = listOf<String>("Jetpack", "Room", "LiveData", "DataBinding")
                Conversation(stars)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable {
            Toast
                .makeText(context, "Hello $name!", Toast.LENGTH_LONG)
                .show()
        }, verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(shape = RoundedCornerShape(50))
                .border(width = 2.dp, color = Color.Cyan, shape = RoundedCornerShape(50)),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "图片内容描述"
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Hello world!",
                modifier = modifier
            )
        }
    }
}

@Composable
fun Conversation(list: List<String>) {
    LazyColumn(content = {
        this.items(list.size) {
            Greeting(list[it])
        }
    })

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        Greeting("Android")
    }
}