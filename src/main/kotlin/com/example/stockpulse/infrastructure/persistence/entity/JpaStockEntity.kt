package com.example.stockpulse.infrastructure.persistence.entity

import com.example.stockpulse.domain.enums.MarketType
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "stocks")
class JpaStockEntity(
    @Id
    @Column(name = "standard_code", unique = true)
    val standardCode: String,

    @Column(name = "short_code")
    val shortCode: String,

    @Column(name = "korean_name")
    val koreanName: String,

    @Column(name = "korean_abbreviation")
    val koreanAbbreviation: String,

    @Column(name = "english_name")
    val englishName: String,

    @Column(name = "listing_date")
    val listingDate: LocalDate,

    @Column(name = "market_type")
    @Enumerated(EnumType.STRING)
    val marketType: MarketType,

    @Column(name = "security_group")
    val securityGroup: String,

    @Column(name = "sector_type")
    val sectorType: String,

    @Column(name = "stock_certificate_type")
    val stockCertificateType: String,

    @Column(name = "par_value")
    val parValue: Int,

    @Column(name = "listed_shares")
    val listedShares: Long,

    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now()
)