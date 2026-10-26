package com.example.practica2_mibv

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica2_mibv.ui.theme.Practica2_MIBVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica2_MIBVTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    /*
                        vaya locura cmo lo he clavado,
                        habia colorpickeado el verde ese
                        que has puesto. pero era muy feo
                            pink does it better
                    */
                    Text(
                        text = "[día], [mes] de [año]",
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.consolas)),
                        modifier = Modifier
                            .background(Color(0xfff5bcda))
                            .fillMaxWidth()
                            .heightIn(40.dp)
                            .wrapContentHeight()
                        )
                    Spacer(Modifier.height(25.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(R.drawable.pfp),
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp)
                        )
                        Spacer(Modifier.width(50.dp))
                        Text(
                            text = "Bienvenido",
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.consolas)),
                            modifier = Modifier
                                .background(Color(0xfff5bcda))
                        )
                    }
                }
            }
        }
    }
}