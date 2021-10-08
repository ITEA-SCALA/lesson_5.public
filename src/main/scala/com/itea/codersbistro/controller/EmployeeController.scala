package com.itea.codersbistro.controller

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{HttpMethods, StatusCodes, Uri}
import akka.http.scaladsl.server.{RequestContext, Route}
import akka.http.scaladsl.server.Directives._

import scala.concurrent.Future
//import com.itea.codersbistro.controller.EmployeeController.QueryEmployee
import com.itea.codersbistro.repository.EmployeeRepository
import com.itea.codersbistro.repository.EmployeeRepository.{ EmployeeNotFoundException, DubiousEmployeeRecordsException }
import com.itea.codersbistro.entity._
import spray.json.DefaultJsonProtocol
import scala.util.{ Failure, Success }

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._


object EmployeeController {
//  case class QueryEmployee(id: Int, firstName: String, lastName: String)

//  object EmployeeJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
//    implicit val addressJson = jsonFormat6( Address.apply )
//    implicit val employeeJson = jsonFormat5( Employee.apply )
////    implicit val employeeQueryJson = jsonFormat3( QueryEmployee.apply )
//  }
}

trait EmployeeController extends EmployeeRepository {

  /**
   * The Actor system to be used by the Future Context.
   *
   * @return
   */
  implicit def actorSystem: ActorSystem

  lazy val logger = Logging(actorSystem, classOf[EmployeeController])

//  import EmployeeRepository._
//  import com.itea.codersbistro.controller.EmployeeController.EmployeeJsonProtocol._

//    implicit val addressJson = jsonFormat6( Address.apply )
//    implicit val employeeJson = jsonFormat5( Employee.apply )

//  lazy val simpleKeyer: PartialFunction[RequestContext, Uri] = {
//    case r: RequestContext if r.request.method == HttpMethods.GET => r.request.uri
//  }
//
//  def complexKeyer(payload: String): PartialFunction[RequestContext, String] = {
//    case r: RequestContext if r.request.method == HttpMethods.POST => s"${r.request.uri}_${payload}"
//  }

  import akka.http.scaladsl.server.directives.CachingDirectives._
  import spray.json._

//  lazy val myCache = routeCache[Uri]
//  lazy val myComplexCache = routeCache[String]

  /**
   * Employee Routes for the GET/POST/Other REST endpoints for the Employee endpoints.
   */
  lazy val employeeRoutes: Route = pathPrefix("employee") {
    get {
      path(Segment) { id =>
        val employee = getEmployeeById( id.toInt )
        /*
         * complete имеет надстройку onComplete
         * а надстройка onComplete имеет 2-а состояния Success и Failure (определяются через паттерн match)
         *
         * json-маршаллер передается именно в complete в качестве implicit
         */
        onComplete( employee ) {
          _ match {
            case Success(employee) =>
              logger.info(s"Got the employee records given the employee id ${id}")
              implicit val addressJson = jsonFormat6( Address.apply )
              implicit val employeeJson = jsonFormat5( Employee.apply )
              complete( StatusCodes.OK, employee ) // TODO:
            case Failure(throwable) =>
              logger.error(s"Failed to get the employee record given the employee id ${id}")
              throwable match {
                case e: EmployeeNotFoundException => complete(StatusCodes.NotFound, "No employee found")
                case e: DubiousEmployeeRecordsException => complete(StatusCodes.NotFound, "Dubious records found.")
                case _ => complete(StatusCodes.InternalServerError, "Failed to get the employees.")
              }
          }
        }
//      } ~ pathPrefix("cached") {
//        path(Segment) { id =>
//          alwaysCache(myCache, simpleKeyer) {
//            onComplete(getEmployeeById(id.toInt)) {
//              _ match {
//                case Success(employee) =>
//                  logger.info(s"Got the employee records given the employee id ${id}")
//                  complete(StatusCodes.OK, employee)
//                case Failure(throwable) =>
//                  logger.error(s"Failed to get the employee record given the employee id ${id}")
//                  throwable match {
//                    case e: EmployeeNotFoundException => complete(StatusCodes.NotFound, "No employee found")
//                    case e: DubiousEmployeeRecordsException => complete(StatusCodes.NotFound, "Dubious records found.")
//                    case _ => complete(StatusCodes.InternalServerError, "Failed to get the employees.")
//                  }
//              }
//            }
//          }
//        }
      }
//    } ~ post {
//      pathPrefix("query") {
//        entity(as[QueryEmployee]) { q =>
//          path("cached") {
//            alwaysCache(myComplexCache, complexKeyer(q.toJson.compactPrint)) {
//              onComplete(queryEmployee(q.id, q.firstName, q.lastName)) {
//                _ match {
//                  case Success(employees) =>
//                    logger.info("Got the employee records for the search query.")
//                    complete(StatusCodes.OK, employees)
//                  case Failure(throwable) =>
//                    logger.error("Failed to get the employees with the given query condition.")
//                    complete(StatusCodes.InternalServerError, "Failed to query the employees.")
//                }
//              }
//            }
//          } ~
//            pathEndOrSingleSlash {
//              onComplete(queryEmployee(q.id, q.firstName, q.lastName)) {
//                _ match {
//                  case Success(employees) =>
//                    logger.info("Got the employee records for the search query.")
//                    complete(StatusCodes.OK, employees)
//                  case Failure(throwable) =>
//                    logger.error("Failed to get the employees with the given query condition.")
//                    complete(StatusCodes.InternalServerError, "Failed to query the employees.")
//                }
//              }
//            }
//        }
//      }
    }
  }
}
