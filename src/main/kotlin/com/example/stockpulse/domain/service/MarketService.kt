package com.example.stockpulse.domain.service

import com.example.stockpulse.domain.entity.enums.MarketType
import com.example.stockpulse.domain.entity.enums.MarketType.KOSDAQ
import com.example.stockpulse.domain.entity.enums.MarketType.KOSPI
import com.example.stockpulse.infrastructure.external.MarketClient
import com.example.stockpulse.presentation.dto.response.DailyTradingDto
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class MarketService(val marketClient: MarketClient) {

    fun getMarkets(type: MarketType, date: LocalDate): List<DailyTradingDto> {
        return when(type){
            KOSPI -> marketClient.getKospiMarket(date)?.OutBlock_1 ?:emptyList()
            KOSDAQ -> marketClient.getKosdaqMarket(date)?.OutBlock_1 ?:emptyList()
        }
    }
}