package com.example.cadastrojogos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class Game(
    val id: Long,
    val titulo: String,
    val genero: String,
    val anoLancamento: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navegador()
        }
    }
}

@Composable
fun Navegador () {
    val jogos = remember { mutableStateListOf<Game>() }
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "principal" ) {

        composable("principal") {
            TelaPrincipal(
                jogos = jogos,
                onIrParaDetalhes = { navController.navigate("detalhes") }
            )
        }

        composable("detalhes") {
            TelaDetalhes(
                jogos = jogos,
                onVoltarParaPrincipal = {navController.popBackStack()}
            )
        }
    }
}

@Composable
fun TelaPrincipal(jogos: MutableList<Game>, onIrParaDetalhes: () -> Unit) {
    var titulo by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var anoLancamento by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Steam Universitária", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título do game") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = genero,
            onValueChange = { genero = it },
            label = { Text("Gênero do game") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = anoLancamento,
            onValueChange = { anoLancamento = it },
            label = { Text("Ano de lançamento") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = {
            val launch = anoLancamento.toIntOrNull()
            // Verificações básicas
            if (titulo.isNotBlank() && genero.isNotBlank() && launch != null && launch >= 1952 && launch <= 2025) {
                jogos.add(Game(System.currentTimeMillis(), titulo, genero, launch))
                titulo = ""
                genero = ""
                anoLancamento = ""
            }
        }) {
            Text("Adicionar")
        }

        Spacer(modifier = Modifier.width(20.dp))

        Text(text = "Jogos: ${jogos.size}", fontSize = 18.sp)}

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(jogos) { jogo ->
                Text(
                    text = jogo.titulo,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onIrParaDetalhes) {
            Text("Detalhes", fontSize = 18.sp)
        }
    }
}

@Composable
fun TelaDetalhes(jogos: List<Game>, onVoltarParaPrincipal: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detalhes", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(jogos) { jogo ->
                Text("Título: " + jogo.titulo)
                Text("Gênero: " + jogo.genero)
                Text("Ano: "  + jogo.anoLancamento)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onVoltarParaPrincipal) {
            Text("Voltar")
        }
    }
}