package com.medium.devspoint.designpatternsfundosvcspring.service.rules

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment

abstract class SectorTechValidation {

    lateinit var next : SectorTechValidation

    fun next(next: SectorTechValidation): SectorTechValidation {
        this.next = next
        return this
    }

    fun checkValidation(investment: Investment): Pair<Boolean, Any> {
        if (isValid(investment)) {
            return Pair(true, investment)
        }
        return next!!.checkValidation(investment)
    }

    abstract fun isValid(investment: Investment): Boolean


}