package com.medium.devspoint.designpatternsfundosvcspring.service.fintech.validations

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.service.SectorTechValidation
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class FinTechStage2Validation : SectorTechValidation() {

    override fun isValid(investment: Investment): Pair<Boolean, String> {
        if (investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                if (investment.value >= 2000000 && investment.value <= 6000000) {
                    return Pair(true, "")
                }
                return Pair(false, "Value to invest should be between 2 to 6 millions dollars for this valuation")
            }
            return Pair(false, "FinTech should be operating for more than 2 years for this Valuation")
        }
        return Pair(false, "")
    }
}