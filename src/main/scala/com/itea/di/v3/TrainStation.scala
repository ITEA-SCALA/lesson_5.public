package com.itea.di.v3

import com.itea.di.v3.loading.LoadingModule
import com.itea.di.v3.shunting.ShuntingModule
import com.itea.di.v3.station.StationModule

object TrainStation extends App {
  val modules = new ShuntingModule
    with LoadingModule
    with StationModule

  modules.trainStation.prepareAndDispatchNextTrain()
}
