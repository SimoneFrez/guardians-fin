package com.guardians.guardiansfin.application.web.exception

import java.time.LocalDateTime

data class ErrorResponse(
    val title: String,
    val status: Int,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val details: String,
    val fields: String? = null
)