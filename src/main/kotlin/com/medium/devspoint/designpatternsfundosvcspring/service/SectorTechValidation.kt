package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment

abstract class SectorTechValidation {

    private var next : SectorTechValidation? = null

    abstract fun isValid(investment: Investment): Boolean

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

    fun nextFinish(finish : SectorTechValidation): SectorTechValidation {
        this.next = finish
        return this
    }

}