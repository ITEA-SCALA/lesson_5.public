package com.itea.codersbistro.repository

import com.itea.codersbistro.entity._

trait EmployeeRepository {
  import scala.concurrent.Future
  import EmployeeRepository._
  import com.itea.codersbistro.repository.Context._

  /**
    * Get the employee details given the Employee Id.
    *
    * @param id
    * @return
    */
  def getEmployeeById(id: Int) = Future(EmployeeDB).map { db =>
    val data = db.filter(_.id == id)
    if (data.isEmpty) throw new EmployeeNotFoundException
    if (data.length > 1) throw new DubiousEmployeeRecordsException
    data(0)
  }

  /**
    * Query the employee repository with the given query condition.
    *
    * @param id
    * @param firstName
    * @param lastName
    * @return
    */
//  def queryEmployee(id: Int, firstName: String, lastName: String): Future[Seq[Employee]] = {
//    Future(EmployeeDB).map { db =>
//      db.filter { elem =>
//        elem.id == id && elem.firstName == firstName && elem.lastName == lastName
//      }
//    }
//  }
}

object EmployeeRepository {
  val EmployeeDB = Seq(
    Employee(100, "Lala", "Lee", true, Address(0, "2234", "Cambridge Street", "Torronto", "Torronto", "2414132")),
    Employee(101, "Nancy", "Argan", true, Address(1, "35", "Waterloo Park", "Niaora", "Nigeria", "546465")),
    Employee(102, "Manilla", "Neptune", true, Address(2, "22", "Bakers Street", "Gurgaon", "Haryana", "21341324")),
    Employee(103, "Neeru", "Andrew", true, Address(3, "3463", "St. Peters Road", "Rocky Hill", "Connecticut", "456546")),
    Employee(104, "Michael", "Nicholas", true, Address(4, "56756", "Aurbhindo Marg", "Minnesota", "Minnetonka", "45242")),
    Employee(105, "Sam", "Montroe", true, Address(5, "12312", "Ethens Street", "Delhi", "Delhi", "235353")),
    Employee(106, "Mila", "Hanson", true, Address(6, "432", "Bridge Road", "San jose", "San Fransico", "3434534")),
    Employee(106, "Manila", "Winston", false, Address(7, "432", "Bridge Road", "San jose", "San Fransico", "3434534"))
  )

  class EmployeeNotFoundException extends Throwable("No employee found in the database.")
  class DubiousEmployeeRecordsException extends Throwable("Dubious Employee records found given the Employee ID.")
}
