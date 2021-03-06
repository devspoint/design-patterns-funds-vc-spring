package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment

interface SectorTech {
    fun sector(): Investment.SectorEnum
    fun saveInvestment(investment: Investment): Investment
}