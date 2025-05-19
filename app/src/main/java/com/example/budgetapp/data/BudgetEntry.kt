package com.example.budgetapp.data

import java.time.LocalDate
import java.util.*

data class BudgetEntry(
    val id: UUID = UUID.randomUUID(),
    val label: String,
    val amount: Int,
    val date: LocalDate = LocalDate.now()
)