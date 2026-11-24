package com.example.practica2_mibv

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme
import java.time.LocalDate

class LlegadaActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isItOscuro = isSystemInDarkTheme()
            var modoOscurito by rememberSaveable { mutableStateOf(isItOscuro) }
            var color = if (modoOscurito) Color(0xFF8F5272) else Color(0xfff5bcda)

            val windowSize = calculateWindowSizeClass(this)
            val pantallaPettit = windowSize.widthSizeClass == WindowWidthSizeClass.Compact
            Practica2_MIBVTheme(
                darkTheme = modoOscurito
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Text(text = if (modoOscurito) "Modo oscuro" else "Modo claro")
                            Switch(
                                checked = modoOscurito,
                                onCheckedChange = { modoOscurito = it }
                            )
                        }
                    }
                ) { innerPading ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPading)
                            .verticalScroll(rememberScrollState())
                            .padding(if (pantallaPettit) 7.dp else 20.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        /*
                            ts es muy complicada estoy cansada
                        */
                        val titulo = intent.getStringExtra("titulo") ?: "Tarea 1"
                        val fecha = intent.getStringExtra("fecha") ?: "Fecha límite"
                        val rol = intent.getStringExtra("rol") ?: "Cliente"
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            letterCuchi(
                                text = "${LocalDate.now().dayOfMonth}, ${LocalDate.now().month} de ${LocalDate.now().year}",
                                color,
                                35
                            )
                            Row {
                                Image(
                                    painterResource(R.drawable.pfp),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(110.dp)
                                )
                                Spacer(Modifier.width(50.dp))
                                Column(
                                    modifier = Modifier.heightIn(110.dp),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    letterCuchi(
                                        "Bienvenido",
                                        color,
                                        25
                                    )
                                    letterCuchi(
                                        "whoishim41",
                                        color,
                                        25
                                    )
                                    letterCuchi(
                                        rol,
                                        color,
                                        25
                                    )
                                }
                            }
                            letterCuchi(
                                text = "Tareas pendientes",
                                color,
                                35
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(55.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier
                                        .weight(1.85f),
                                    verticalArrangement = Arrangement.spacedBy(25.dp)
                                ) {
                                    letterCuchi(titulo, color, 35)
                                    letterCuchi("Tarea 2", color, 35)
                                    letterCuchi("Tarea 3", color, 35)
                                }
                                Column(
                                    modifier = Modifier
                                        .weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(25.dp)
                                ) {
                                    letterCuchi(fecha, color, 35)
                                    letterCuchi("Fecha límite", color, 35)
                                    letterCuchi("Fecha límite", color, 35)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(if (pantallaPettit) 25.dp else 50.dp))
                        val context = LocalContext.current
                        Column(
                            modifier = Modifier.height(if (pantallaPettit) 120.dp else 150.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Button(
                                onClick = {
                                    val intent = Intent(context, NuevaTareaActivity::class.java)
                                    startActivity(intent)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text("Añadir tarea")
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Button(
                                    onClick = {
                                        val intent = Intent(context, PerfilActivity::class.java)
                                        startActivity(intent)
                                    },
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Perfil")
                                }
                                Button(
                                    onClick = {},
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Ajustes")
                                }
                            }
                            Button(
                                onClick = {
                                    val intent = Intent(context, TItulosActivity::class.java)
                                    startActivity(intent)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text("Mis titulos")
                            }
                        }
                    }
                }
            }
        }


    }
}

@Composable
fun letterCuchi(text: String, color: Color, height: Int) {
    Text(
        text = text,
        modifier = Modifier
            .background(color)
            .fillMaxWidth()
            .heightIn(height.dp)
            .wrapContentHeight()
    )
}