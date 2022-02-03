package com.example.testapp.domain.models

data class AwayTeam(
    val country: Country,
    val logo: String,
    val name: String,
    val short_code: String,
    val team_id: Int
)