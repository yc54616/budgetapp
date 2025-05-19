package com.example.budgetapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.*

data class Entry(val id: UUID = UUID.randomUUID(), val label: String, val amount: Int)

@Composable
fun HomeScreen() {
    var label by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var entries by remember { mutableStateOf(listOf<Entry>()) }

    val total = entries.sumOf { it.amount }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("가계부", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = label,
            onValueChange = { label = it },
            label = { Text("내용") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("금액") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Button(onClick = {
                val amt = amount.toIntOrNull() ?: 0
                if (label.isNotBlank() && amt != 0) {
                    entries = entries + Entry(label = label, amount = amt)
                    label = ""
                    amount = ""
                }
            }) {
                Text("추가")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { entries = emptyList() }) {
                Text("초기화")
            }
        }

        Text("총 합계: ${total}원")

        entries.forEach { entry ->
            Text("${entry.label}: ${entry.amount}원")
        }
    }
}