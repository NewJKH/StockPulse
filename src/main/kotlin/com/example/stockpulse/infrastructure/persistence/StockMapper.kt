package com.example.stockpulse.infrastructure.persistence

import com.example.stockpulse.domain.entity.stock.Stock
import com.example.stockpulse.infrastructure.persistence.entity.JpaStockEntity
import com.example.stockpulse.presentation.dto.response.IsuInfoDto

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
    fun IsuInfoDto.toDomain(): Stock {
        return Stock(
            standardCode = this.isuCd,
            shortCode = this.isuSrtCd,
            koreanName = this.isuNm,
            englishName = this.isuEngNm,
            koreanAbbreviation = this.isuAbbrv,
            listingDate = this.listDd,
            marketType = this.mktTpNm,
            securityGroup = this.secugrpNm,
            sectorType = this.sectTpNm,
            stockCertificateType = this.kindStkcertTpNm,
            parValue = this.parval,
            listedShares = this.listShrs
        )
    }
}