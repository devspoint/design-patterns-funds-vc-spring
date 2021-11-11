package com.medium.devspoint.designpatternsfundosvcspring.controller

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.service.InvestmentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/investments")
class InvestmentController(
        private val investmentService: InvestmentService
) {

    @PostMapping
    fun create(@RequestBody investmentRequest: Investment) : Investment {
        return this.investmentService.save(investmentRequest)
    }
}