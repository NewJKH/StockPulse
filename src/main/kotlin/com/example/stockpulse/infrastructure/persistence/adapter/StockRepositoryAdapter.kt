package com.example.stockpulse.infrastructure.persistence.adapter

import com.example.stockpulse.domain.entity.Stock
import com.example.stockpulse.domain.respository.StockRepository
import com.example.stockpulse.infrastructure.persistence.StockMapper.toDomain
import com.example.stockpulse.infrastructure.persistence.StockMapper.toJpaEntity
import com.example.stockpulse.infrastructure.persistence.repository.StockEntityRepository
import org.springframework.stereotype.Repository

@Repository
class StockRepositoryAdapter(
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