package com.example.stockpulse.application.service

import com.example.stockpulse.application.mapper.ApplicationMapper.toDomain
import com.example.stockpulse.domain.enums.MarketType
import com.example.stockpulse.domain.respository.StockRepository
import com.example.stockpulse.infrastructure.external.MarketApiClient
import com.example.stockpulse.presentation.dto.response.DailyTradingDto
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class MarketService(
    private val stockRepository: StockRepository,
    private val marketClient: MarketApiClient
) {

    fun getMarkets(type: MarketType, date: LocalDate): List<DailyTradingDto> {
        return when(type){
            MarketType.KOSPI -> marketClient.getKospiMarket(date)?.OutBlock_1 ?:emptyList()
            MarketType.KOSDAQ -> marketClient.getKosdaqMarket(date)?.OutBlock_1 ?:emptyList()
        }
    }

    fun saveMarket(targetDate: LocalDate) {
        val entity = marketClient.getKospiMarketInfo(targetDate)
            ?.OutBlock_1
            ?.map { it.toDomain() }
        stockRepository.saveAll(entity)
    }

}