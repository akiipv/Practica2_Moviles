package com.example.practica2_mibv

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isItOscuro = isSystemInDarkTheme()
            var modoOscurito by remember { mutableStateOf(isItOscuro) }
            var color = if (isSystemInDarkTheme()) Color(0xFF8F5272) else Color(0xfff5bcda)
            Practica2_MIBVTheme(
                darkTheme = modoOscurito
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(25.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        val opciones = listOf("Administrador", "Cliente")
                        var opcionSeleccionada by remember { mutableStateOf(opciones[0]) }
                        var correo by remember { mutableStateOf(false) }

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
                        letterCuchi("Perfil de usuario", color, 40)
                        Image(
                            painterResource(R.drawable.pfp),
                            contentDescription = null,
                            modifier = Modifier
                                .size(110.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            letterSad("Nombre de usuario", color, 20, 50)
                            letterSad(opcionSeleccionada, color, 20, 50)
                        }
                        TextField(
                            value = "",
                            onValueChange = {},
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            readOnly = true,
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color(0xFF3A2532),
                                focusedContainerColor = Color(0xA9E0DCDE),
                                focusedTextColor = Color.Black,
                                cursorColor = Color(0xFF3A2532),
                                unfocusedContainerColor = Color(0xFFE0DCDE),
                                unfocusedTextColor = Color.Black,
                                unfocusedIndicatorColor = Color(0xFF3A2532)
                            )
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                letterSad("Rol actual", color, 20, 50)
                                opciones.forEach { opcion ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { opcionSeleccionada = opcion }
                                    ) {
                                        RadioButton(
                                            selected = (opcion == opcionSeleccionada),
                                            onClick = { opcionSeleccionada = opcion }
                                        )
                                        Text(text = opcion)
                                    }
                                }
                            }
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                letterSad("Ajustes de correo", color, 20, 50)

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Checkbox(
                                        checked = correo,
                                        onCheckedChange = { correo = it }
                                    )
                                    Text("Recibir correo")
                                }
                            }
                        }

                        val context = LocalContext.current
                        Button(
                            onClick = {
                                val intent = Intent(context, LlegadaActivity::class.java).apply {
                                    putExtra("rol", opcionSeleccionada)
                                }
                                startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text("Volver al menú principal")
                        }
                    }
                }
            }
        }
    }
}