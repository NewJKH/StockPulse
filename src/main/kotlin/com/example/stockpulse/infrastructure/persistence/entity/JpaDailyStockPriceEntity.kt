package com.example.stockpulse.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "daily_stock_price")
data class JpaDailyStockPriceEntity(
    @EmbeddedId
    val standardCode: String,

    @Column(name = "closing_price")
    val closingPrice: Long,

    @Column(name = "trade_date")
    val tradeDate: LocalDate,
)