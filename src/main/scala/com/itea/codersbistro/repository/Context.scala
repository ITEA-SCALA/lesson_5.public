package com.itea.codersbistro.repository

import akka.actor.ActorSystem

object Context {
  lazy val actorSystem = ActorSystem("context")
//  lazy val scheduler = actorSystem.scheduler
  implicit lazy val executionContext = actorSystem.dispatcher
}