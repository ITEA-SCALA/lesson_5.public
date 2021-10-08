package com.itea.di.v3

package loading {
  import com.itea.di.v3.shunting.PointSwitcher

  class CraneController() { println("4. Crane Controller") }
  class TrainLoader(craneController: CraneController, pointSwitcher: PointSwitcher) { println("5. Train Loader 4+1)") }
}
