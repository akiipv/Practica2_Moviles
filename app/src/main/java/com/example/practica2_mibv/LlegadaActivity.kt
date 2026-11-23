package com.example.practica2_mibv

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme

class LlegadaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica2_MIBVTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp)
                ) {
                    innerPading ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPading),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        /*
                            vaya locura cmo lo he clavado,
                            habia colorpickeado el verde ese
                            que has puesto. pero era muy feo
                                pink does it better
                        */
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            letterCuchi(
                                text = "[día], [mes] de [año]",
                                Color(0xfff5bcda),
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
                                        Color(0xfff5bcda),
                                        25
                                    )
                                    letterCuchi(
                                        "[nombre de usuario]",
                                        Color(0xfff5bcda),
                                        25
                                    )
                                    letterCuchi(
                                        "[rol de usuario]",
                                        Color(0xfff5bcda),
                                        25
                                    )
                                }
                            }
                            letterCuchi(
                                text = "Tareas pendientes",
                                Color(0xfff5bcda),
                                35
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(55.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column (
                                    modifier = Modifier
                                        .weight(1.85f),
                                    verticalArrangement = Arrangement.spacedBy(25.dp)
                                ) {
                                    letterCuchi("Tarea 1", Color(0xfff5bcda), 35)
                                    letterCuchi("Tarea 2", Color(0xfff5bcda), 35)
                                    letterCuchi("Tarea 3", Color(0xfff5bcda), 35)
                                }
                                Column (
                                    modifier = Modifier
                                        .weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(25.dp)
                                ) {
                                    letterCuchi("Fecha límite", Color(0xfff5bcda), 35)
                                    letterCuchi("Fecha límite", Color(0xfff5bcda), 35)
                                    letterCuchi("Fecha límite", Color(0xfff5bcda), 35)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        val context = LocalContext.current
                        Column(
                            modifier = Modifier.height(120.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
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
                                    onClick = {},
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
}