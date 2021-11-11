package com.medium.devspoint.designpatternsfundosvcspring.fixtures

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import java.time.LocalDate

fun logTechSector() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 500999.0,
                companyValuation = 11000000.0,
                sector = Investment.SectorEnum.LOGTECH,
                startDate = LocalDate.of(2019,3,5)
        )

fun finTechWithValuation500ThousandDollars() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 500000.0,
                companyValuation = 100777.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.of(2019,3,5)
        )

fun finTech2MounthsAgo() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 1000999.0,
                companyValuation = 10100777.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(2)
        )

fun finTechWithValueToInvest19DollarsAnd90Cents() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 19.90,
                companyValuation = 10100777.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(15)
        )

fun finTechValueToInvest2millions999Thousand19Dolars90Cents() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 2999019.90,
                companyValuation = 10100777.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(15)
        )

fun finTechValidWithValuationBetween10to15millions() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 500999.0,
                companyValuation = 11000000.0,
                id = null,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

fun fintech1yearsAgoWithValuation21millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 1000999.0,
                companyValuation = 21000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusYears(1)
        )

fun finTechWithValueToInvest1MillionWithValuation21Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 1000000.00,
                companyValuation = 21000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(26)
        )

fun finTechWithValueToInvest7MillionsWithValuation21Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 7099019.90,
                companyValuation = 21000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

fun finTechWithValuation21MillionsAnd2YearsAgoAndValueToInvest2millions() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 2500999.0,
                companyValuation = 21000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(26)
        )

fun fintech1DayAgoWithValuation50Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 1000999.0,
                companyValuation = 50000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusDays(1)
        )

fun finTechWithValueToInvest1MillionWithValuation50MillionsAnd3yearsAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 1000000.00,
                companyValuation = 50000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(37)
        )

fun finTechWithValueToInvest12MillionWithValuation50MillionsAnd3yearsAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 12000000.00,
                companyValuation = 50000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(37)
        )

fun finTechWithValuation50MillionsAnd3YearsAgoAndValueToInvest7millions() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 7500999.0,
                companyValuation = 50000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(37)
        )

// HealthTech

fun healthTechWithValuation70MillionsDollars() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 70500000.0,
                companyValuation = 100777.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.of(2019,3,5)
        )

fun healthTech1DayAgoWithValuation3Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 300000.0,
                companyValuation = 3000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusDays(1)
        )

fun healthTechWithValueToInvest50ThousandWithValuation3MillionsAnd1yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 100000.00,
                companyValuation = 3000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

fun healthTechWithValueToInvest700ThousandWithValuation3MillionsAnd1yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 700000.00,
                companyValuation = 3000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

fun healthTechWithValuation3MillionsAnd1YearAgoAndValueToInvest250Thousand() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 250000.0,
                companyValuation = 3000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

fun healthTech1YearAgoWithValuation10Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 900000.0,
                companyValuation = 10000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusDays(13)
        )

fun healthTechWithValueToInvest100ThousandWithValuation10MillionsAnd2yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 100000.00,
                companyValuation = 10000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

fun healthTechWithValueToInvest3MillionWithValuation10MillionsAnd2yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 3000000.00,
                companyValuation = 10000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

fun healthTechWithValuation10MillionsAnd2YearAgoAndValueToInvest900Thousand() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 900000.0,
                companyValuation = 10000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

fun healthTech1YearAgoWithValuation35Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 900000.0,
                companyValuation = 35000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusDays(13)
        )

fun healthTechWithValueToInvest999ThousandWithValuation35MillionsAnd2yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 999000.00,
                companyValuation = 30000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

fun healthTechWithValueToInvest4MillionsWithValuation35MillionsAnd2yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 4000000.00,
                companyValuation = 35000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

fun healthTechWithValuation35MillionsAnd2YearAgoAndValueToInvest2Millions() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 2000000.0,
                companyValuation = 35000000.0,
                sector = Investment.SectorEnum.HEALTHTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

// FoodTech

fun foodTechWithValuation70MillionsDollars() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 70500000.0,
                companyValuation = 70000777.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.of(2019,3,5)
        )

fun foodTech1YearAgoWithValuation13Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 13000000.0,
                companyValuation = 13000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusDays(10)
        )

fun foodTechWithValueToInvest599ThousandWithValuation13MillionsAnd1yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 599000.00,
                companyValuation = 13000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

fun foodTechWithValueToInvest2MillionsWithValuation13MillionsAnd1yearAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 2000000.00,
                companyValuation = 13000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

fun foodTechWithValuation13MillionsAnd1YearAgoAndValueToInvest1Million() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 1000000.0,
                companyValuation = 13000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

fun foodTech2YearsAgoWithValuation30Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 13000000.0,
                companyValuation = 30000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusDays(26)
        )

fun foodTechWithValueToInvest999ThousandWithValuation30MillionsAnd2yearsAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 999000.00,
                companyValuation = 30000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(26)
        )

fun foodTechWithValueToInvest5MillionsWithValuation30MillionsAnd2yearsAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 5000000.00,
                companyValuation = 30000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(25)
        )

fun foodTechWithValuation30MillionsAnd2YearsAgoAndValueToInvest1Million() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 1000000.0,
                companyValuation = 30000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(26)
        )

fun foodTech2YearsAgoWithValuation42Millions() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 13000000.0,
                companyValuation = 42000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusDays(26)
        )


fun foodTechWithValueToInvest999ThousandWithValuation42MillionsAnd3yearsAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 999000.00,
                companyValuation = 42000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(38)
        )

fun foodTechWithValueToInvest7MillionsWithValuation42MillionsAnd3yearsAgoOperating() =
        Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 7099000.00,
                companyValuation = 42000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(38)
        )

fun foodTechWithValuation42MillionsAnd3YearsAgoAndValueToInvest3Million() =
        Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 3000000.0,
                companyValuation = 42000000.0,
                sector = Investment.SectorEnum.FOODTECH,
                startDate = LocalDate.now().minusMonths(38)
        )