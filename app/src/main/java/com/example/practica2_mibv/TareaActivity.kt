package com.example.practica2_mibv

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme

class TareaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica2_MIBVTheme {
                Scaffold(
                    modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp)
                ) { innerPading ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPading),
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        val titulo: String = intent.getStringExtra("titulo") ?: "Tarea"
                        val desc: String = intent.getStringExtra("desc") ?: ""
                        val prioridad: Int = intent.getIntExtra("prioridad", 0)

                        letterCuchi(titulo, Color(0xfff5bcda), 45)
                        letterCuchi(desc, Color(0xfff5bcda), 120)
                        letterCuchi(prioridad.toString(), Color(0xfff5bcda), 45)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Absolute.SpaceBetween
                            ) {
                                letterSad("Prioridad", Color(0xfff5bcda), 0, 90)
                                letterSad("Fecha límite", Color(0xfff5bcda), 0, 90)
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Absolute.SpaceBetween
                            ) {
                                letterSad(prioridad.toString(), Color(0xfff5bcda), 0, 150)
                                letterSad("Fecha límite", Color(0xfff5bcda), 0, 150)
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

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text("Guardar Tarea")
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                onClick = {
                                    val intent = Intent(context, LlegadaActivity::class.java)
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