package com.example.stockpulse.infrastructure.persistence.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "stocks")
class JpaStockEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

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
    val listingDate: String,

    @Column(name = "market_type")
    val marketType: String,

    @Column(name = "security_group")
    val securityGroup: String,

    @Column(name = "sector_type")
    val sectorType: String,

    @Column(name = "stock_certificate_type")
    val stockCertificateType: String,

    @Column(name = "par_value")
    val parValue: String,

    @Column(name = "listed_shares")
    val listedShares: String,

    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now()
)