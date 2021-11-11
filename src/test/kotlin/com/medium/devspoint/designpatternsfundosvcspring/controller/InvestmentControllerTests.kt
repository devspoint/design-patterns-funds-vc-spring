package com.medium.devspoint.designpatternsfundosvcspring.controller

import com.medium.devspoint.designpatternsfundosvcspring.controller.handles.ResponseData
import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import com.medium.devspoint.designpatternsfundosvcspring.fixtures.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class InvestmentControllerTests {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun testCreateInvestmentLogTechSectorNotAllowedToInvest() {
        val investment = logTechSector()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Sector not allowed to invest", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValuationInvalid() {
        val investment = finTechWithValuation500ThousandDollars()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Valuation Not Allowed for FinTech, valuation should be between 10 to 60 millions dollars", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechOperationTimeInvalidForValuation10to15millions() {
        val investment = finTech2MounthsAgo()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("FinTech should be operating for more than 2 years for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidLteForValuation10to15millions() {
        val investment = finTechWithValueToInvest19DollarsAnd90Cents()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 500 thousand to 2 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidGteForValuation10to15millions() {
        val investment = finTechValueToInvest2millions999Thousand19Dolars90Cents()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 500 thousand to 2 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValidWithValuation10to15millions() {
        val investment = finTechValidWithValuationBetween10to15millions()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

    @Test
    fun testCreateInvestmentFinTechOperationTimeInvalidForValuation15to40millions() {
        val investment = fintech1yearsAgoWithValuation21millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("FinTech should be operating for more than 2 years for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidLteForValuation15to40millions() {
        val investment = finTechWithValueToInvest1MillionWithValuation21Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 2 to 6 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidGteForValuation15to40millions() {
        val investment = finTechWithValueToInvest7MillionsWithValuation21Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 2 to 6 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValidWithValuation15to40millions() {
        val investment = finTechWithValuation21MillionsAnd2YearsAgoAndValueToInvest2millions()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

    @Test
    fun testCreateInvestmentFinTechOperationTimeInvalidForValuation40to60millions() {
        val investment = fintech1DayAgoWithValuation50Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("FinTech should be operating for more than 3 years for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidLteForValuation40to60millions() {
        val investment = finTechWithValueToInvest1MillionWithValuation50MillionsAnd3yearsAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 6 to 10 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidGteForValuation40to60millions() {
        val investment = finTechWithValueToInvest12MillionWithValuation50MillionsAnd3yearsAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 6 to 10 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValidWithValuation40to60millions() {
        val investment = finTechWithValuation50MillionsAnd3YearsAgoAndValueToInvest7millions()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

    @Test
    fun testCreateInvestmentHealthTechValuationInvalid() {
        val investment = healthTechWithValuation70MillionsDollars()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Valuation Not Allowed for HealthTech, valuation should be between 3 to 60 millions dollars", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechOperationTimeInvalidForValuation3to8millions() {
        val investment = healthTech1DayAgoWithValuation3Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("HealthTech should be operating for more than 1 year for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValueToInvestInvalidLteForValuation3to8millions() {
        val investment = healthTechWithValueToInvest50ThousandWithValuation3MillionsAnd1yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 200 to 600 thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValueToInvestInvalidGteForValuation3to8millions() {
        val investment = healthTechWithValueToInvest700ThousandWithValuation3MillionsAnd1yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 200 to 600 thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValidWithValuation3to8millions() {
        val investment = healthTechWithValuation3MillionsAnd1YearAgoAndValueToInvest250Thousand()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }


    @Test
    fun testCreateInvestmentHealthTechOperationTimeInvalidForValuation8to15millions() {
        val investment = healthTech1YearAgoWithValuation10Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("HealthTech should be operating for more than 1 year for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValueToInvestInvalidLteForValuation8to15millions() {
        val investment = healthTechWithValueToInvest100ThousandWithValuation10MillionsAnd2yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 600 thousand to 2 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValueToInvestInvalidGteForValuation8to15millions() {
        val investment = healthTechWithValueToInvest3MillionWithValuation10MillionsAnd2yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 600 thousand to 2 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValidWithValuation8to15millions() {
        val investment = healthTechWithValuation10MillionsAnd2YearAgoAndValueToInvest900Thousand()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

    @Test
    fun testCreateInvestmentHealthTechOperationTimeInvalidForValuation15to40millions() {
        val investment = healthTech1YearAgoWithValuation35Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("HealthTech should be operating for more than 2 year for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValueToInvestInvalidLteForValuation15to40millions() {
        val investment = healthTechWithValueToInvest999ThousandWithValuation35MillionsAnd2yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 1 to 3 millions dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValueToInvestInvalidGteForValuation15to40millions() {
        val investment = healthTechWithValueToInvest4MillionsWithValuation35MillionsAnd2yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 1 to 3 millions dollars for this valuation", response.body!!.message)
    }


    @Test
    fun testCreateInvestmentHealthTechValidWithValuation15to40millions() {
        val investment = healthTechWithValuation35MillionsAnd2YearAgoAndValueToInvest2Millions()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

    // FoodTech

    @Test
    fun testCreateInvestmentFoodTechValuationInvalid() {
        val investment = foodTechWithValuation70MillionsDollars()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Valuation Not Allowed for FoodTech, valuation should be between 10 to 60 millions dollars", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechOperationTimeInvalidForValuation10to15millions() {
        val investment = foodTech1YearAgoWithValuation13Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("FoodTech should be operating for more than 1 year for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechValueToInvestInvalidLteForValuation10to15millions() {
        val investment = foodTechWithValueToInvest599ThousandWithValuation13MillionsAnd1yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 600 thousand to 1.2 millions thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValueToInvestInvalidGteForValuation10to15millions() {
        val investment = foodTechWithValueToInvest2MillionsWithValuation13MillionsAnd1yearAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 600 thousand to 1.2 millions thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentHealthTechValidWithValuation10to15millions() {
        val investment = foodTechWithValuation13MillionsAnd1YearAgoAndValueToInvest1Million()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

    @Test
    fun testCreateInvestmentFoodTechOperationTimeInvalidForValuation15to40millions() {
        val investment = foodTech2YearsAgoWithValuation30Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("FoodTech should be operating for more than 2 year for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechValueToInvestInvalidLteForValuation15to40millions() {
        val investment = foodTechWithValueToInvest999ThousandWithValuation30MillionsAnd2yearsAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 1 to 4 millions thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechValueToInvestInvalidGteForValuation15to40millions() {
        val investment = foodTechWithValueToInvest5MillionsWithValuation30MillionsAnd2yearsAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 1 to 4 millions thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechValidWithValuation15to40millions() {
        val investment = foodTechWithValuation30MillionsAnd2YearsAgoAndValueToInvest1Million()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

    @Test
    fun testCreateInvestmentFoodTechOperationTimeInvalidForValuation40to60millions() {
        val investment = foodTech2YearsAgoWithValuation42Millions()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("FoodTech should be operating for more than 3 year for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechValueToInvestInvalidLteForValuation40to60millions() {
        val investment = foodTechWithValueToInvest999ThousandWithValuation42MillionsAnd3yearsAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 2 to 6 millions thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechValueToInvestInvalidGteForValuation40to60millions() {
        val investment = foodTechWithValueToInvest7MillionsWithValuation42MillionsAnd3yearsAgoOperating()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        assertEquals(412, response.statusCodeValue)
        assertEquals("Value to invest should be between 2 to 6 millions thousand dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFoodTechValidWithValuation40to60millions() {
        val investment = foodTechWithValuation42MillionsAnd3YearsAgoAndValueToInvest3Million()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        assertEquals(200, response.statusCodeValue)
        assertNotNull(response.body!!.id)
    }

}