package com.example.stockpulse.presentation.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.UpperSnakeCaseStrategy::class)
data class IsuInfoDto(
    val isuCd: String,                    // ISU_CD
    val isuSrtCd: String,                 // ISU_SRT_CD
    val isuNm: String,                    // ISU_NM
    val isuAbbrv: String,                 // ISU_ABBRV
    val isuEngNm: String,                 // ISU_ENG_NM
    val listDd: String,                   // LIST_DD
    val mktTpNm: String,                  // MKT_TP_NM
    val secugrpNm: String,                // SECUGRP_NM
    val sectTpNm: String,                 // SECT_TP_NM
    val kindStkcertTpNm: String,          // KIND_STKCERT_TP_NM
    val parval: String,                   // PARVAL
    val listShrs: String                  // LIST_SHRS
)