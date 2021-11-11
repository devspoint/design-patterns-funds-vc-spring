package com.medium.devspoint.designpatternsfundosvcspring.service.fintech.validations

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.service.SectorTechValidation
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class FinTechStage3Validation : SectorTechValidation() {

    override fun isValid(investment: Investment): Pair<Boolean, String> {
        if (investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                if (investment.value >= 6000000 && investment.value <= 10000000) {
                    return Pair(true, "")
                }
                return Pair(false, "Value to invest should be between 6 to 10 millions dollars for this valuation")
            }
            return Pair(false, "FinTech should be operating for more than 3 years for this Valuation")
        }
        return Pair(false, "Valuation Not Allowed for FinTech, valuation should be between 10 to 60 millions dollars")
    }
}