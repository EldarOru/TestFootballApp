package com.example.testapp.domain.models

data class Match(
    val away_team: AwayTeam,
    val home_team: HomeTeam,
    val league_id: Int,
    val match_id: Int,
    val match_start: String,
    val season_id: Int,
    val stats: Stats,
    val status: String,
    val status_code: Int,
    val venue: Venue
)