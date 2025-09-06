package com.example.stockpulse.presentation.controller

import com.example.stockpulse.domain.entity.enums.MarketType
import com.example.stockpulse.domain.service.MarketService
import com.example.stockpulse.presentation.dto.response.DailyTradingDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class MarketController(private val marketService: MarketService) {

    @GetMapping("/{market}/stocks")
    fun getMarketByType(
        @PathVariable market: MarketType,
        @RequestParam(required = false) date: LocalDate?
    ): Any {
        val targetDate = date ?: LocalDate.now()
        val response: List<DailyTradingDto> = marketService.getMarkets(market,targetDate)

        return mapOf(
            "success" to true,
            "date" to date,
            "dataCount" to response.size,
            "sampleData" to response.take(3),
            "fullData" to response
        )
    }
}