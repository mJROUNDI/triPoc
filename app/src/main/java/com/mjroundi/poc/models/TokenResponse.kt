package com.mjroundi.poc.models

/**
 * Created by mJroundi on 10/02/2019.
 */
data class TokenResponse(
    val access_token: String,
    val client_id: String,
    val expires_in: Int,
    val issued_at: Int,
    val scopes: List<String>,
    val token_type: String
)