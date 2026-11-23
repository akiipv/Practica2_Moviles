package com.example.practica2_mibv

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class NuevaTareaActivity : ComponentActivity() {
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
                        val titulo = rememberTextFieldState()
                        val desc = rememberTextFieldState()
                        var priority by remember { mutableFloatStateOf(0f) }
                        val state = rememberDatePickerState()
                        var fecha by remember { mutableStateOf("Elige una fecha") }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Text(text = if (modoOscurito) "Modo oscuro" else "Modo claro")
                            Switch(
                                checked = modoOscurito,
                                onCheckedChange = { modoOscurito = it }
                            )
                        }
                        letterCuchi("Añadir nueva tarea", Color(0xfff5bcda), 45)
                        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            letterSad("Titulo", Color(0xfff5bcda), 0, 90)
                            TextField(
                                state = titulo,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                lineLimits = TextFieldLineLimits.SingleLine,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = Color(0xFF3A2532),
                                    focusedContainerColor = Color(0xA9E0DCDE),
                                    focusedTextColor = Color.Black,
                                    cursorColor = Color(0xFF3A2532),
                                    unfocusedContainerColor = Color(0xffe0dcde),
                                    unfocusedTextColor = Color.Black,
                                    unfocusedIndicatorColor = Color(0xFF3A2532)
                                )
                            )
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            letterSad("Descripción", Color(0xfff5bcda), 0, 90)
                            TextField(
                                state = desc,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = Color(0xFF3A2532),
                                    focusedContainerColor = Color(0xA9E0DCDE),
                                    focusedTextColor = Color.Black,
                                    cursorColor = Color(0xFF3A2532),
                                    unfocusedContainerColor = Color(0xffe0dcde),
                                    unfocusedTextColor = Color.Black,
                                    unfocusedIndicatorColor = Color(0xFF3A2532)
                                )
                            )
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            letterSad("Prioridad", Color(0xfff5bcda), 0, 90)
                            Slider(
                                value = priority,
                                onValueChange = { priority = it },
                                enabled = true,
                                valueRange = 0f..10f,
                                steps = 9,
                                colors = SliderDefaults.colors(
                                    thumbColor = Color(0xFFF5BCDA),
                                    activeTrackColor = Color(0xFF3A2532),
                                    inactiveTrackColor = Color(0xFFF5BCDA),
                                    activeTickColor = Color(0xFFF5BCDA),
                                    inactiveTickColor = Color(0xFF3A2532)
                                )
                            )
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            letterSad("Fecha límite", Color(0xfff5bcda), 0, 90)
                            LaunchedEffect(state.selectedDateMillis) {
                                state.selectedDateMillis?.let { millis ->
                                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).apply {
                                        timeZone = TimeZone.getTimeZone("UTC")
                                    }
                                    fecha = sdf.format(Date(millis))
                                }
                            }

                            Column(
                                modifier = Modifier.fillMaxWidth().padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = fecha,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                DatePicker(
                                    state = state,
                                    title = null,
                                    headline = null,
                                    showModeToggle = false
                                )
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
                                    val intent = Intent(context, TareaActivity::class.java).apply {
                                        putExtra("titulo", titulo.text.toString())
                                        putExtra("desc", desc.text.toString())
                                        putExtra("prioridad", priority)
                                        putExtra("fecha", fecha)
                                    }
                                    startActivity(intent)
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
}