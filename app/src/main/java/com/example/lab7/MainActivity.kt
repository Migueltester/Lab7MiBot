package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7.ui.theme.Lab7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF121212) // Fondo oscuro general
                ) { innerPadding ->
                    PresentationCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PresentationCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Imagen del bot o logo (cámbiala por la que quieras)
        Image(
            painter = painterResource(id = R.drawable.android_bot),
            contentDescription = "Avatar",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(160.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre y título
        Text(
            text = "Miguelangel Ortega",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "Ingeniero de Software",
            fontSize = 16.sp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Contacto
        ContactItem("📧 migueltester@gmail.com")
        ContactItem("🌐 github.com/Migueltester")
        ContactItem("📱 +507 6848-4663")

        Spacer(modifier = Modifier.height(32.dp))

        // Habilidades destacadas
        Text(
            text = "Habilidades",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E1E1E), RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            SkillItem("🐳 Docker & Docker Compose")
            SkillItem("🛠 Arquitectura de Microservicios")
            SkillItem("⚙️ CI/CD con Jenkins & GitHub Actions")
            SkillItem("☁️ Kubernetes (Básico)")
            SkillItem("📝 Documentación API (Swagger / Postman)")
            SkillItem("📐 Clean Architecture & SOLID")
        }
    }
}

@Composable
fun ContactItem(info: String) {
    Text(
        text = info,
        color = Color.White,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
    Divider(color = Color.White.copy(alpha = 0.3f), thickness = 1.dp, modifier = Modifier.padding(horizontal = 32.dp))
}

@Composable
fun SkillItem(skill: String) {
    Text(
        text = skill,
        color = Color.White,
        fontSize = 14.sp,
        modifier = Modifier.padding(vertical = 4.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF121212)
@Composable
fun PresentationCardPreview() {
    Lab7Theme {
        PresentationCard()
    }
}
