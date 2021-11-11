package com.medium.devspoint.designpatternsfundosvcspring.service.fintech.validations

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.OperatingTimeInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValueToInvestInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.service.SectorTechValidation
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class FinTechStage3Validation : SectorTechValidation() {

    override fun isValid(investment: Investment): Boolean {
        if (investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                if (investment.value >= 6000000 && investment.value <= 10000000) {
                    return true
                }
                throw ValueToInvestInvalidException("Value to invest should be between 6 to 10 millions dollars for this valuation")
            }
            throw OperatingTimeInvalidException("FinTech should be operating for more than 3 years for this Valuation")
        }
        return false
    }
}