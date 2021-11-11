package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.repository.InvestmentRepository
import org.springframework.stereotype.Service

@Service
class InvestmentService(
        private val strategy: SectorTechStrategy,
        private val repository: InvestmentRepository
) {

    fun save(investment: Investment): Investment {
        return strategy.get(investment.sector)
                       .checkValidations(investment)
                       .run(repository::save)
    }

}