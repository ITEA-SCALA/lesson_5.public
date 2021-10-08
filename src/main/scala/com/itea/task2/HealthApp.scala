package com.itea.task2

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}

object HealthApp extends App with LoadingModule {
  val config: Config = ConfigFactory.load().getConfig("config.rest")

  implicit val system: ActorSystem = ActorSystem("akka-http")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val port = config.getString("port").toInt
  val bindingFuture = Http()
    .bindAndHandle(
      controller.doGet,
      config.getString("interface"),
      port)

  implicit val log = Logging(system, "HealthApp$")
  log.info(s"Server started at the port $port")

}
