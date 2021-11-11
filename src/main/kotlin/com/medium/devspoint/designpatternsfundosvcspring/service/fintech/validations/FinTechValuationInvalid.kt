package com.medium.devspoint.designpatternsfundosvcspring.service.fintech.validations

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValuationInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.service.SectorTechValidation
import org.springframework.stereotype.Component

@Component
class FinTechValuationInvalid : SectorTechValidation()  {

    override fun isValid(investment: Investment): Boolean {
        throw ValuationInvalidException("Valuation Not Allowed for FinTech, valuation should be between 10 to 60 millions dollars")
    }
}