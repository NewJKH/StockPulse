package com.example.stockpulse.infrastructure.external

import com.example.stockpulse.presentation.dto.reequest.KrxRequest
import com.example.stockpulse.presentation.dto.response.DailyTradingDto
import com.example.stockpulse.presentation.dto.response.IsuInfoDto
import com.example.stockpulse.presentation.dto.response.KrxResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class MarketClient {

    @Value("\${krx.api.key}")
    private lateinit var apiKey: String

    private val restClient: RestClient = RestClient.builder()
        .baseUrl("https://data-dbg.krx.co.kr")
        .build()

    fun getKosdaqMarket(date: LocalDate): KrxResponse<DailyTradingDto>? {
        val dateString = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

        return restClient.post()
            .uri("/svc/apis/sto/ksq_bydd_trd")
            .header("AUTH_KEY",apiKey)
            .body(KrxRequest(basDd = dateString))
            .retrieve()
            .body(object : ParameterizedTypeReference<KrxResponse<DailyTradingDto>>() {})
    }

    fun getKospiMarket(date: LocalDate): KrxResponse<DailyTradingDto>? {
        val dateString = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

        return restClient.post()
            .uri("/svc/apis/sto/stk_bydd_trd")
            .header("AUTH_KEY",apiKey)
            .body(KrxRequest(basDd = dateString))
            .retrieve()
            .body(object : ParameterizedTypeReference<KrxResponse<DailyTradingDto>>() {})
    }

    fun getKospiMarketInfo(date: LocalDate): KrxResponse<IsuInfoDto>? {
        val dateString = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"))

        return restClient.post()
            .uri("/svc/apis/sto/stk_isu_base_info")
            .header("AUTH_KEY",apiKey)
            .body(KrxRequest(basDd = dateString))
            .retrieve()
            .body(object : ParameterizedTypeReference<KrxResponse<IsuInfoDto>>() {})
    }
}