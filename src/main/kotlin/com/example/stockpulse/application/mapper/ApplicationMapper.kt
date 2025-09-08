package com.example.stockpulse.application.mapper

import com.example.stockpulse.domain.entity.Stock
import com.example.stockpulse.domain.enums.MarketType
import com.example.stockpulse.presentation.dto.response.IsuInfoDto
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
object ApplicationMapper {
    fun IsuInfoDto.toDomain(): Stock {
        return Stock(
            standardCode = this.isuCd,
            shortCode = this.isuSrtCd,
            koreanName = this.isuNm,
            englishName = this.isuEngNm,
            koreanAbbreviation = this.isuAbbrv,
            listingDate = LocalDate.parse(this.listDd),
            marketType = MarketType.valueOf(this.mktTpNm),
            securityGroup = this.secugrpNm,
            sectorType = this.sectTpNm,
            stockCertificateType = this.kindStkcertTpNm,
            parValue = this.parval.toInt(),
            listedShares = this.listShrs.toLong()
        )
    }
}