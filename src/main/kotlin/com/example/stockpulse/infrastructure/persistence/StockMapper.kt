package com.example.stockpulse.infrastructure.persistence

import com.example.stockpulse.domain.entity.Stock
import com.example.stockpulse.infrastructure.persistence.entity.JpaStockEntity

object StockMapper {
    fun Stock.toJpaEntity(): JpaStockEntity {
        return JpaStockEntity(
            standardCode = this.standardCode,
            shortCode = this.shortCode,
            koreanName = this.koreanName,
            englishName = this.englishName,
            koreanAbbreviation = this.koreanAbbreviation,
            listingDate = this.listingDate,
            marketType = this.marketType,
            securityGroup = this.securityGroup,
            sectorType = this.sectorType,
            stockCertificateType = this.stockCertificateType,
            parValue = this.parValue,
            listedShares = this.listedShares
        )
    }
    fun JpaStockEntity.toDomain(): Stock {
        return Stock(
            standardCode = this.standardCode,
            shortCode = this.shortCode,
            koreanName = this.koreanName,
            englishName = this.englishName,
            koreanAbbreviation = this.koreanAbbreviation,
            listingDate = this.listingDate,
            marketType = this.marketType,
            securityGroup = this.securityGroup,
            sectorType = this.sectorType,
            stockCertificateType = this.stockCertificateType,
            parValue = this.parValue,
            listedShares = this.listedShares
        )
    }
}