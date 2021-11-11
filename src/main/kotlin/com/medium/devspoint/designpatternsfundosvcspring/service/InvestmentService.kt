package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import org.springframework.stereotype.Service

@Service
class InvestmentService(
        private val strategy: SectorTechStrategy
) {

    fun save(investment: Investment): Investment {
        return strategy.get(investment.sector).saveInvestment(investment)
    }
}