package com.medium.devspoint.designpatternsfundosvcspring.service.fintech

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.exceptions.StartupInvalidException
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.service.SectorTech
import com.medium.devspoint.designpatternsfundosvcspring.service.fintech.validations.FinTechStage1Validation
import com.medium.devspoint.designpatternsfundosvcspring.service.fintech.validations.FinTechStage3Validation
import com.medium.devspoint.designpatternsfundosvcspring.service.fintech.validations.FinTechStage2Validation
import org.springframework.stereotype.Service

@Service
class FinTechValidationChain(
        val finTechStageOneValidation: FinTechStage1Validation,
        val finTechStageTwoValidation: FinTechStage2Validation,
        val finTechStageThreeValidation: FinTechStage3Validation
) : SectorTech {

    override fun sector() = Investment.SectorEnum.FINTECH

    override fun checkValidations(investment: Investment) : Investment {
        finTechStageOneValidation
                .next(finTechStageTwoValidation
                .next(finTechStageThreeValidation
                .nextFinish()))
            .checkValidation(investment).let {
                if(it.first) { return it.second as Investment }
                throw StartupInvalidException(it.second.toString())
           }
    }

}