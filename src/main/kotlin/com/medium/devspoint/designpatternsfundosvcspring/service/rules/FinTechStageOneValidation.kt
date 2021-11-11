package com.medium.devspoint.designpatternsfundosvcspring.service.rules

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import java.time.LocalDate

class FinTechStageOneValidation : SectorTechValidation() {

    override fun isValid(investment: Investment): Boolean {
        if(investment.companyValuation in 1.0E7..1.5E7) {
            if(investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                if (investment.value >= 600000 && investment.value <= 1200000) {
                    return true
                }
            }
        }
        return false
    }
}