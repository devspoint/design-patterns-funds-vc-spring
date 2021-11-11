package com.medium.devspoint.designpatternsfundosvcspring.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
data class Investment(
        @Id var id: String? = null,
        var companyCnpj: String? = null,
        var companyName: String? = null,
        var companyValuation: Double = 0.0.toDouble(),
        var sector: SectorEnum? = null,
        var value: Double = 0.0.toDouble(),
        var startDate: LocalDate? = null
) {
    enum class SectorEnum {
        FINTECH, HEALTHTECH, FOODTECH, RETAILTECH, AGTECH, LOGTECH, MARTECH
    }
}