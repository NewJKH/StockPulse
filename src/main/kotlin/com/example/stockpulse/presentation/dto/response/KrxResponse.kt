package com.example.stockpulse.presentation.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.UpperSnakeCaseStrategy::class)
data class KrxResponse<T>(
    val outBlock1: List<T> // OUT_BLOCK_1
)