package com.pablosj.cryptotutorialcompose.domain.model

import com.pablosj.cryptotutorialcompose.data.remote.dto.TeamMember

data class ItemDetail(
    val conId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
)
