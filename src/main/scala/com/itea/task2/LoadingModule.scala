package com.itea.task2

import com.itea.task2.controller.HealthController
import com.itea.task2.dao.HealthDao
import com.itea.task2.service.HealthService
import com.softwaremill.macwire._

trait LoadingModule {
  lazy val dao = wire[HealthDao]
  lazy val service = wire[HealthService]
  lazy val controller = wire[HealthController]
}
