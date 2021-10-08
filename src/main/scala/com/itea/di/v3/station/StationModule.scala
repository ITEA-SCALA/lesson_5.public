package com.itea.di.v3

package station {
  import com.itea.di.v3.loading.TrainLoader
  import com.itea.di.v3.shunting.TrainShunter
  import com.softwaremill.macwire.wire

  trait StationModule {
    lazy val trainDispatch = wire[TrainDispatch]

    lazy val trainStation = wire[TrainStation]

    // dependencies of the module
    def trainShunter: TrainShunter
    def trainLoader: TrainLoader
  }
}
