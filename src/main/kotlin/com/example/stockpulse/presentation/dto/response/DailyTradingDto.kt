package com.example.stockpulse.presentation.dto.response

data class DailyTradingDto(
    val BAS_DD: String,          // 기준일자
    val ISU_CD: String,          // 종목코드
    val ISU_NM: String,          // 종목명
    val MKT_NM: String,          // 시장구분
    val SECT_TP_NM: String,      // 소속부
    val TDD_CLSPRC: String,      // 종가
    val CMPPREVDD_PRC: String,   // 대비
    val FLUC_RT: String,         // 등락률
    val TDD_OPNPRC: String,      // 시가
    val TDD_HGPRC: String,       // 고가
    val TDD_LWPRC: String,       // 저가
    val ACC_TRDVOL: String,      // 거래량
    val ACC_TRDVAL: String,      // 거래대금
    val MKTCAP: String,          // 시가총액
    val LIST_SHRS: String        // 상장주식수
)
