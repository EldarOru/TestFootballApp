package com.example.testapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.databinding.MatchBinding
import com.example.testapp.domain.internet.RetrofitServices
import com.example.testapp.domain.models.AwayTeam
import com.example.testapp.domain.models.HomeTeam
import com.example.testapp.domain.models.Match

class MatchesListAdapter(private val context: Context): RecyclerView.Adapter<MatchesListAdapter.MatchItemViewHolder>() {

    var onHomeTeamClickListener: ((HomeTeam) -> Unit)? = null
    var onAwayTeamClickListener: ((AwayTeam) -> Unit)? = null

    var list = listOf<Match>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchItemViewHolder {
        val matchView = MatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchItemViewHolder(matchView)
    }

    override fun onBindViewHolder(holder: MatchItemViewHolder, position: Int) {
        val match = list[position]
        holder.matchBinding.apply {
            awayTeamCountryTv.text = match.away_team.country.name
            awayTeamTv.text = match.away_team.name
            homeTeamCountryTv.text = match.home_team.country.name
            homeTeamTv.text = match.home_team.name
            matchStartTv.text = "Match started: ${match.match_start}"
            scoreTv.text = match.stats.ft_score
            venueCityTv.text = match.venue.city
            venueNameTv.text = match.venue.name
            Glide.with(context).load(match.away_team.logo).into(awayTeamIv)
            Glide.with(context).load(match.home_team.logo).into(homeTeamIv)

            awayTeamIv.setOnClickListener {
                onAwayTeamClickListener!!.invoke(match.away_team)
            }
            homeTeamIv.setOnClickListener {
                onHomeTeamClickListener!!.invoke(match.home_team)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MatchItemViewHolder(val matchBinding: MatchBinding): RecyclerView.ViewHolder(matchBinding.root)
}