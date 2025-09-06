package com.example.stockpulse.infrastructure.persistence

import com.example.stockpulse.domain.entity.stock.Stock
import com.example.stockpulse.domain.respository.StockRepository
import com.example.stockpulse.infrastructure.persistence.StockMapper.toDomain
import com.example.stockpulse.infrastructure.persistence.StockMapper.toJpaEntity
import org.springframework.stereotype.Repository

@Repository
class StockJpaRepositoryImpl(
    private val stockJpaRepository: StockEntityRepository
) : StockRepository {
    override fun save(stock: Stock) {
        val entity = stock.toJpaEntity()
        stockJpaRepository.save(entity)
    }

    override fun findAll(): List<Stock> {
        return stockJpaRepository.findAll()
            .map { it.toDomain() }
    }

    override fun saveAll(stocks: List<Stock>?) {
        val entities = stocks!!.map { it.toJpaEntity() }
        stockJpaRepository.saveAll(entities)
    }
}