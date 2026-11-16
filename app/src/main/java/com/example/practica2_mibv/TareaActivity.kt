package com.example.practica2_mibv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                        letterCuchi("Añadir nueva tarea", Color(0xfff5bcda), 45)
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