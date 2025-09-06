package com.example.stockpulse.presentation.controller

import com.example.stockpulse.application.service.MarketService
import com.example.stockpulse.domain.entity.stock.enums.MarketType
import com.example.stockpulse.presentation.dto.response.DailyTradingDto
import org.springframework.web.bind.annotation.*
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


    @PostMapping("/admin/data-sync")
    fun manualSync(
        @RequestParam(required = false) date: LocalDate?
    ): String{
        val targetDate = date ?: LocalDate.now()
        marketService.saveMarket(targetDate);
        return "데이터가 저장되었습니다."
    }
}