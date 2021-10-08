//package com.itea.codersbistro.service
//
//import scala.concurrent.Future
//import io.bfil.automapper.automap
//import com.itea.codersbistro.entity._
//import com.itea.codersbistro.dto._
//import com.itea.codersbistro.repository._
//
//class EmployeeService(repository: EmployeeRepository) {
//  def getEmployeeById(id: Int) = automap(repository.getEmployeeById(id)).to[EmployeeDto]
//  def queryEmployee(id: Int, firstName: String, lastName: String) = {
//    val employees: Future[Seq[Employee]] = repository.queryEmployee(id, firstName, lastName)
//    val a = employees.map { e =>
//      val entity = e(0)
//      val dto: EmployeeDto = automap(entity).to[EmployeeDto]
//      dto
//    }
//  }
//}
