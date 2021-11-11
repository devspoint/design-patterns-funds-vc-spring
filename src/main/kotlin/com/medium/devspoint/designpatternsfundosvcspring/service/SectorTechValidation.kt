package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.ValuationInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment

abstract class SectorTechValidation {

    private var next : SectorTechValidation? = null

    abstract fun isValid(investment: Investment): Pair<Boolean, String>

    fun next(next: SectorTechValidation): SectorTechValidation {
        this.next = next
        return this
    }

    fun checkValidation(investment: Investment): Pair<Boolean, Any> {
        if (isValid(investment).first) {
            return Pair(true, investment)
        }
        return next!!.checkValidation(investment)
    }

    fun nextFinish(): SectorTechValidation {
        throw ValuationInvalidException("Valuation Not Allowed for FinTech, valuation should be between 10 to 60 millions dollars")
    }

}