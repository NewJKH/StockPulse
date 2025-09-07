package com.example.stockpulse.infrastructure.persistence.repository

import com.example.stockpulse.infrastructure.persistence.entity.JpaStockEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StockEntityRepository : JpaRepository<JpaStockEntity, Long>