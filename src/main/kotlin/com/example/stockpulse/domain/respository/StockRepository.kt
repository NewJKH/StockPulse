package com.example.stockpulse.domain.respository

import com.example.stockpulse.domain.entity.Stock

interface StockRepository {
    fun save(stock: Stock)
    fun findAll(): List<Stock>
    fun saveAll(stocks: List<Stock>?)
}