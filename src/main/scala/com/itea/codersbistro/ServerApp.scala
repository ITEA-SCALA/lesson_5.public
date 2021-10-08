package com.itea.codersbistro

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import com.itea.codersbistro.controller.EmployeeController
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object ServerApp extends App with EmployeeController {
  implicit val actorSystem = ActorSystem("AkkaHTTPExampleServices")
  implicit val materializer = ActorMaterializer()

  lazy val apiRoutes: Route = pathPrefix("api") {
    employeeRoutes
  }

  Http().bindAndHandle(apiRoutes, "localhost", 8080)
  logger.info("Starting the HTTP server at 8080")
  Await.result(actorSystem.whenTerminated, Duration.Inf)
}
