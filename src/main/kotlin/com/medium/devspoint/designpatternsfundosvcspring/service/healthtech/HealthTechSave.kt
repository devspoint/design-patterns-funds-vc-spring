package com.medium.devspoint.designpatternsfundosvcspring.service.healthtech

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.OperatingTimeInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValuationInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValueToInvestInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.repository.InvestmentRepository
import com.medium.devspoint.designpatternsfundosvcspring.service.SectorTech
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class HealthTechSave(
        private val investmentRepository: InvestmentRepository
) : SectorTech {

    override fun sector() = Investment.SectorEnum.HEALTHTECH

    override fun checkValidations(investment: Investment) : Investment {
        if (investment.companyValuation >= 3000000 && investment.companyValuation <= 8000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                if (investment.value >= 200000 && investment.value <= 600000) {
                    return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 200 to 600 thousand dollars for this valuation")
            }
            throw OperatingTimeInvalidException("HealthTech should be operating for more than 1 year for this Valuation")
        }
        if (investment.companyValuation > 8000000 && investment.companyValuation <= 15000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                if (investment.value >= 600000 && investment.value <= 2000000) {
                    return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 600 thousand to 2 millions dollars for this valuation")
            }
            throw OperatingTimeInvalidException("HealthTech should be operating for more than 1 year for this Valuation")
        }
        if (investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                if (investment.value >= 1000000 && investment.value <= 3000000) {
                    return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 1 to 3 millions dollars for this valuation")
            }
            throw OperatingTimeInvalidException("HealthTech should be operating for more than 2 year for this Valuation")
        }
        throw ValuationInvalidException("Valuation Not Allowed for HealthTech, valuation should be between 3 to 60 millions dollars")
    }
}