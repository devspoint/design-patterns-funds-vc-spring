package com.medium.devspoint.designpatternsfundosvcspring.repository

import com.medium.devspoint.designpatternsfundosvcspring.entity.Investment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InvestmentRepository : CrudRepository<Investment, String> {
}