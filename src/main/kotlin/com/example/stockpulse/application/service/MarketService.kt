package com.example.stockpulse.application.service

import com.example.stockpulse.domain.entity.stock.enums.MarketType
import com.example.stockpulse.domain.respository.StockRepository
import com.example.stockpulse.infrastructure.external.MarketClient
import com.example.stockpulse.infrastructure.persistence.StockMapper.toDomain
import com.example.stockpulse.presentation.dto.response.DailyTradingDto
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class MarketService(
    private val stockRepository: StockRepository,
    private val marketClient: MarketClient
) {

    fun getMarkets(type: MarketType, date: LocalDate): List<DailyTradingDto> {
        return when(type){
            MarketType.KOSPI -> marketClient.getKospiMarket(date)?.outBlock1 ?:emptyList()
            MarketType.KOSDAQ -> marketClient.getKosdaqMarket(date)?.outBlock1 ?:emptyList()
        }
    }

    fun saveMarket(targetDate: LocalDate) {
        val entity = marketClient.getKospiMarketInfo(targetDate)
            ?.outBlock1
            ?.map { it.toDomain() }
        stockRepository.saveAll(entity)
    }

}