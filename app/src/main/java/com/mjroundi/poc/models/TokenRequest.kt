package com.mjroundi.poc.models

/**
 * Created by mJroundi on 10/02/2019.
 */
data class TokenRequest(
    val client_id: String,
    val client_secret: String,
    val grant_type: String,
    val scopes: List<String>
)