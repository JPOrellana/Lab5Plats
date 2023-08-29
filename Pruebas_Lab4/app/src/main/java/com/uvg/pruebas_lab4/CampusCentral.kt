package com.uvg.pruebas_lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.pruebas_lab4.ui.theme.Pruebas_Lab4Theme

class CampusCentral : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pruebas_Lab4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InfoCampus()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CampusInfoPreview() {
    Pruebas_Lab4Theme {
        InfoCampus()
    }
}

@Composable
fun InfoCampus() {
    val context = LocalContext.current

    BackHandler {
        context.findActivity()?.finish()
    }

    Surface {
        Column {
            CentralCampus()
            Featured()
            ServicesAndResources()
        }
    }
}


@Composable
fun CentralCampus(){
    val campus = painterResource(id = R.drawable.uvg)
    val back = painterResource(id = R.drawable.reg)
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row (horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth())
        {
            Image(painter = back,
                contentDescription = "Back Arrow",
                modifier = Modifier
                    .absoluteOffset(0.dp, 16.dp)
                    .size(40.dp)
                    .clickable { context.startActivity(Intent(context, MainActivity::class.java)) })

            Text(text = "Campus Central",
                style = TextStyle(color = Color.Black, fontSize = 26.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(20.dp))

            Text(text = "       ")
        }
        Image(painter = campus,
            contentDescription = "Front Page Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(200.dp))
    }
}
@Composable
fun Featured(){
    Text(text = "Destacados",
        style = TextStyle(color = Color.Gray, fontSize = 24.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp))

    Row (modifier = Modifier
        .fillMaxWidth()
        .size(180.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        ServiceNow(modifier = Modifier.weight(1f))
        News(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ServiceNow(modifier: Modifier = Modifier){
    val sn = painterResource(id = R.drawable.uvg1)

    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = sn,
            contentDescription = "Service Now Image",
            modifier = Modifier.size(100.dp))

        Box(modifier = Modifier
            .width(180.dp)
            .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
            .background(color = Color(21, 115, 32)))
        {
            Text(text = "Service Now",
                style = TextStyle(color = Color.White, fontSize = 15.sp),
                modifier = Modifier.padding(15.dp))
        }
    }
}

@Composable
fun News(modifier: Modifier = Modifier){
    val news = painterResource(id = R.drawable.uvg2)

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = news,
            contentDescription = "News Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(180.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)))

        Box(modifier = Modifier
            .width(180.dp)
            .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
            .background(color = Color.DarkGray))
        {
            Text(text = "Actualidad UVG",
                style = TextStyle(color = Color.White, fontSize = 15.sp),
                modifier = Modifier.padding(15.dp))
        }
    }
}


@Composable
fun ServicesAndResources() {
    Text(text = "Servicios y Recursos",
        style = TextStyle(color = Color.Gray, fontSize = 24.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp))

    Row (modifier = Modifier
        .fillMaxWidth()
        .size(180.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        ServiceDirectory(modifier = Modifier.weight(1f))
        Library(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ServiceDirectory(modifier: Modifier = Modifier) {
    val services = painterResource(id = R.drawable.uvg3)

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = services,
            contentDescription = "Student Services Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(180.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)))

        Box(modifier = Modifier
            .width(180.dp)
            .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
            .background(color = Color(21, 115, 32))
            .padding(10.dp))
        {
            Text(text = "Directorio de Servicios Estudiantiles",
                style = TextStyle(color = Color.White, fontSize = 15.sp)
            )
        }
    }
}

@Composable
fun Library(modifier: Modifier = Modifier) {
    val bib = painterResource(id = R.drawable.uvg4)

    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = bib,
            contentDescription = "Library Image",
            modifier = Modifier.height(100.dp))

        Box(modifier = Modifier
            .width(180.dp)
            .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
            .background(color = Color.DarkGray)
            .padding(10.dp))
        {
            Text(text = "Portal Web Bibliotecas UVG",
                style = TextStyle(color = Color.White, fontSize = 15.sp)
            )
        }
    }
}