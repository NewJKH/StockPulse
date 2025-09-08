package com.example.stockpulse.domain.entity

import java.time.LocalDate

data class DailyStockPrice(
    val closingPrice: Long,    //종가
    val tradeDate: LocalDate   //거래일
)
