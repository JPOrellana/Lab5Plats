package com.uvg.pruebas_lab4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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

class MiPeril : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pruebas_Lab4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PaginaMP()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MyProfilePreview() {
    Pruebas_Lab4Theme {
        PaginaMP()
    }
}


@Composable
fun PaginaMP(){
    val context = LocalContext.current

    BackHandler {
        context.findActivity()?.finish()
    }

    Surface {
        Column (modifier = Modifier.verticalScroll(rememberScrollState()))
        {
            Profile()
            Menu()
        }
    }
}

@Composable
fun Profile(){
    val context = LocalContext.current
    val avatar = painterResource(id = R.drawable.uvg)
    val configur = painterResource(id = R.drawable.tuerca)
    val bgprofile = painterResource(id = R.drawable.portada)
    val back = painterResource(id = R.drawable.reg)

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

            Text(text = "Mi Perfil",
                style = TextStyle(color = Color.Black, fontSize = 26.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(20.dp))

            Image(painter = configur,
                contentDescription = "Settings logo", Modifier.absoluteOffset(0.dp,25.dp))
        }

        Box (
            Modifier
                .fillMaxWidth()
                .height(200.dp))
        {
            Image(painter = bgprofile,
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .alpha(0.6f))


            Image(painter = avatar,
                contentDescription = "Profile Avatar",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center)
                    .absoluteOffset(0.dp, 40.dp))
        }

        Text(text = "JOSÉ PABLO ORELLANA",
            style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp))
    }
}

@Composable
fun Menu(){
    val calendar = painterResource(id = R.drawable.cale)
    val groups = painterResource(id = R.drawable.grupo)
    val grades = painterResource(id = R.drawable.notifi)
    val schedule = painterResource(id = R.drawable.pendientes)
    val friends = painterResource(id = R.drawable.amigos)
    val courses = painterResource(id = R.drawable.curso)
    val campus = painterResource(id = R.drawable.campus)

    Column (Modifier.fillMaxWidth())
    {
        Divider(color = Color.Gray, thickness = 1.dp)

        Row {
            Image(painter = campus,
                contentDescription = "MyCampus logo",
                modifier = Modifier
                    .size(40.dp)
                    .absoluteOffset(0.dp, 15.dp))

            Column {
                Text(text = "Mi Campus",
                    style = TextStyle(color = Color.Black, fontSize = 20.sp),
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 10.dp))

                Text(text = "Campus Central",
                    style = TextStyle(color = Color.Black, fontSize = 15.sp),
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 10.dp))
            }
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Row {
            Image(painter = friends,
                contentDescription = "MyFriends logo",
                modifier = Modifier
                    .size(40.dp)
                    .absoluteOffset(0.dp, 15.dp) )

            Text(text = "Mis Amigos",
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                modifier = Modifier.padding(20.dp))
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Row {
            Image(painter = calendar,
                contentDescription = "MyCalendar logo",
                modifier = Modifier
                    .size(40.dp)
                    .absoluteOffset(0.dp, 15.dp))

            Text(text = "Mi Calendario",
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                modifier = Modifier.padding(20.dp))
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Row {
            Image(painter = courses,
                contentDescription = "MyCourses logo",
                modifier = Modifier
                    .size(40.dp)
                    .absoluteOffset(0.dp, 15.dp))

            Text(text = "Mis Cursos",
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                modifier = Modifier.padding(20.dp))
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Row {
            Image(painter = grades,
                contentDescription = "MyGrades logo",
                modifier = Modifier
                    .size(40.dp)
                    .absoluteOffset(0.dp, 15.dp))

            Text(text = "Mis Calificaciones",
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                modifier = Modifier.padding(20.dp))
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Row {
            Image(painter = groups,
                contentDescription = "MyGroups logo",
                modifier = Modifier
                    .size(40.dp)
                    .absoluteOffset(0.dp, 15.dp))

            Text(text = "Mis Grupos",
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                modifier = Modifier.padding(20.dp))
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        Row {
            Image(painter = schedule,
                contentDescription = "MyEvents logo",
                modifier = Modifier
                    .size(40.dp)
                    .absoluteOffset(0.dp, 15.dp))

            Text(text = "Mis Eventos Proximos",
                style = TextStyle(color = Color.Black, fontSize = 20.sp),
                modifier = Modifier.padding(20.dp))
        }
    }
}