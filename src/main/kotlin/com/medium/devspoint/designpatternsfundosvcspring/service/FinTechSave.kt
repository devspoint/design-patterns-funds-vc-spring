package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.OperatingTimeInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValuationInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValueToInvestInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.repository.InvestmentRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class FinTechSave(
        //private val investmentRepository: InvestmentRepository
) : SectorTech {

    override fun sector() = Investment.SectorEnum.FINTECH

    override fun checkValidations(investment: Investment) : Investment {
        if (check(investment)) return investment
        if (investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                if (investment.value >= 2000000 && investment.value <= 6000000) {
                    //return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 2 to 6 millions dollars for this valuation")
            }
            throw OperatingTimeInvalidException("FinTech should be operating for more than 2 years for this Valuation")
        }
        if (investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                if (investment.value >= 6000000 && investment.value <= 10000000) {
                    //return investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 6 to 10 millions dollars for this valuation")
            }
            throw OperatingTimeInvalidException("FinTech should be operating for more than 3 years for this Valuation")
        }
        throw ValuationInvalidException("Valuation Not Allowed for FinTech, valuation should be between 10 to 60 millions dollars")
    }

    private fun check(investment: Investment): Boolean {
        if (investment.companyValuation >= 10000000 && investment.companyValuation <= 15000000) {
            if (investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                if (investment.value >= 500000 && investment.value <= 2000000) {
                    return true //investmentRepository.save(investment)
                }
                throw ValueToInvestInvalidException("Value to invest should be between 500 thousand to 2 millions dollars for this valuation")
            }
            throw OperatingTimeInvalidException("FinTech should be operating for more than 2 years for this Valuation")
        }
        return false
    }
}