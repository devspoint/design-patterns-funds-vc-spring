package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.OperatingTimeInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValuationInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValueToInvestInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.repository.InvestmentRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class FoodTechSave(
        private val investmentRepository: InvestmentRepository
) : SectorTech {

    override fun sector() = Investment.SectorEnum.FOODTECH

    override fun saveInvestment(investment: Investment) : Investment {
        if (investment.companyValuation >= 10000000 && investment.companyValuation <= 15000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                if (investment.value >= 600000 && investment.value <= 1200000) {
                    return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 600 thousand to 1.2 millions thousand dollars for this valuation")
            }
            throw OperatingTimeInvalidException("FoodTech should be operating for more than 1 year for this Valuation")
        }
        if (investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                if (investment.value >= 1000000 && investment.value <= 4000000) {
                    return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 1 to 4 millions thousand dollars for this valuation")
            }
            throw OperatingTimeInvalidException("FoodTech should be operating for more than 2 year for this Valuation")
        }
        if (investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                if (investment.value >= 2000000 && investment.value <= 6000000) {
                    return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 2 to 6 millions thousand dollars for this valuation")
            }
            throw OperatingTimeInvalidException("FoodTech should be operating for more than 3 year for this Valuation")
        }
        throw ValuationInvalidException("Valuation Not Allowed for FoodTech, valuation should be between 10 to 60 millions dollars")
    }
}