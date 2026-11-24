package com.example.practica2_mibv

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme

class TareaActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isItOscuro = isSystemInDarkTheme()
            var modoOscurito by remember { mutableStateOf(isItOscuro) }
            var color = if (modoOscurito) Color(0xFF8F5272) else Color(0xfff5bcda)
            Practica2_MIBVTheme(
                darkTheme = modoOscurito
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        Row(
                            modifier = Modifier.padding(15.dp),
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
                            .padding(25.dp),
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        val titulo: String = intent.getStringExtra("titulo") ?: "Tarea"

                        val desc: String = intent.getStringExtra("desc") ?: ""
                        val prioridad: Float = intent.getFloatExtra("prioridad", 0f)
                        val fecha = intent.getStringExtra("fecha")

                        letterCuchi(titulo, color, 45)
                        letterCuchi(desc, color, 120)
                        letterCuchi(prioridad.toString(), color, 45)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Absolute.SpaceBetween
                            ) {
                                letterSad("Prioridad", color, 0, 90)
                                letterSad("Fecha límite", color, 0, 90)
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Absolute.SpaceBetween
                            ) {
                                letterSad(prioridad.toString(), color, 0, 150)
                                letterSad(fecha.toString(), color, 0, 150)
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            val context = LocalContext.current
                            Button(
                                onClick = {
                                    val intent =
                                        Intent(context, NuevaTareaActivity::class.java).apply {
                                            putExtra("titulo", titulo)
                                            putExtra("desc", desc)
                                            putExtra("prioridad", prioridad)
                                            putExtra("fecha", fecha)
                                        }
                                    startActivity(intent)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text("Editar Tarea")
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                onClick = {
                                    val intent =
                                        Intent(context, LlegadaActivity::class.java).apply {
                                            putExtra("titulo", titulo)
                                            putExtra("fecha", fecha)
                                        }
                                    startActivity(intent)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text("Volver al menú principal")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun letterSad(text: String, color: Color, height: Int, width: Int) {
    Text(
        text = text,
        modifier = Modifier
            .background(color)
            .sizeIn(width.dp, height.dp)
            .wrapContentHeight()
    )
}