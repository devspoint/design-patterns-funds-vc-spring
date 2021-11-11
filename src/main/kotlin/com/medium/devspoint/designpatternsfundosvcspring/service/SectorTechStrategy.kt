package com.medium.devspoint.designpatternsfundosvcspring.service

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import org.springframework.stereotype.Component

@Component
class SectorTechStrategy(
        private val strategies : List<SectorTech>
) {
    fun get(sectorEnum: Investment.SectorEnum?) : SectorTech {
        return strategies.stream()
                .filter { it.sector() == sectorEnum }
                .findFirst()
                .orElseThrow { throw IllegalArgumentException("Sector not allowed to invest") }
    }
}