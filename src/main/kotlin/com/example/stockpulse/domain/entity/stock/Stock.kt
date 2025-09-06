package com.example.stockpulse.domain.entity.stock

data class Stock(
    val standardCode: String,           // ISU_CD - 표준코드
    val shortCode: String,              // ISU_SRT_CD - 단축코드
    val koreanName: String,             // ISU_NM - 한글 종목명
    val koreanAbbreviation: String,     // ISU_ABBRV - 한글 종목약명
    val englishName: String,            // ISU_ENG_NM - 영문 종목명
    val listingDate: String,            // LIST_DD - 상장일
    val marketType: String,             // MKT_TP_NM - 시장구분
    val securityGroup: String,          // SECUGRP_NM - 증권구분
    val sectorType: String,             // SECT_TP_NM - 소속부
    val stockCertificateType: String,   // KIND_STKCERT_TP_NM - 주식종류
    val parValue: String,               // PARVAL - 액면가
    val listedShares: String            // LIST_SHRS - 상장주식수
)