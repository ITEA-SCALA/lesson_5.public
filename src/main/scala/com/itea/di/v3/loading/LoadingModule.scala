package com.itea.di.v3

package loading {
  import com.itea.di.v3.shunting.PointSwitcher
  import com.softwaremill.macwire.wire

  trait LoadingModule {
    lazy val craneController = wire[CraneController]
    lazy val trainLoader = wire[TrainLoader]

    // dependency of the module
    def pointSwitcher: PointSwitcher
  }
}
