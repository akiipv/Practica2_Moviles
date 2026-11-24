package com.example.practica2_mibv

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme

class TItulosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isItOscuro = isSystemInDarkTheme()
            var modoOscurito by remember { mutableStateOf(isItOscuro) }
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
                    },
                    bottomBar = {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            val context = LocalContext.current
                            Button(
                                onClick = {
                                    val intent = Intent(context, LlegadaActivity::class.java)
                                    startActivity(intent)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                            ) {
                                Text("Volver al menú principal")
                            }
                        }
                    }
                ) { innerPadding ->
                    val context = LocalContext.current
                    LazyColumn(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(25.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        items(sleepyReaderDCsv(context)) { item ->
                            tituloCard(item)
                        }
                    }
                }
            }
        }
    }
}

fun sleepyReaderDCsv(context: Context): List<Titulo> {
    val titulos = mutableListOf<Titulo>()
    val br = context
        .resources
        .openRawResource(R.raw.titulos)
        .bufferedReader()
        .use { br ->
            br.forEachLine { linea ->
                val campos = linea.split(",")
                val titulo = Titulo(
                    campos[0],
                    campos[1],
                    campos[2],
                    campos[3].toInt(),
                    campos[4],
                    campos[5].toInt()
                )
                titulos.add(titulo)
            }
        }
    return titulos
}

@Composable
fun tituloCard(item: Titulo) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.titulo)
                Text(text = item.fechaLanzamiento.toString())
            }
            Text(text = item.descripcion)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.puntuación.toString())
                Text(text = item.plataforma)
                Text(text = item.nJugadores.toString())
            }
        }
    }
}
