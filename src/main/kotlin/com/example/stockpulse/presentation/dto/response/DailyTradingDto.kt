package com.example.stockpulse.presentation.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.UpperSnakeCaseStrategy::class)
data class DailyTradingDto(
    val basDd: String,           // 기준일자 (BAS_DD)
    val isuCd: String,           // 종목코드 (ISU_CD)
    val isuNm: String,           // 종목명 (ISU_NM)
    val mktNm: String,           // 시장구분 (MKT_NM)
    val sectTpNm: String,        // 소속부 (SECT_TP_NM)
    val tddClsprc: String,       // 종가 (TDD_CLSPRC)
    val cmpprevddPrc: String,    // 대비 (CMPPREVDD_PRC)
    val flucRt: String,          // 등락률 (FLUC_RT)
    val tddOpnprc: String,       // 시가 (TDD_OPNPRC)
    val tddHgprc: String,        // 고가 (TDD_HGPRC)
    val tddLwprc: String,        // 저가 (TDD_LWPRC)
    val accTrdvol: String,       // 거래량 (ACC_TRDVOL)
    val accTrdval: String,       // 거래대금 (ACC_TRDVAL)
    val mktcap: String,          // 시가총액 (MKTCAP)
    val listShrs: String         // 상장주식수 (LIST_SHRS)
)