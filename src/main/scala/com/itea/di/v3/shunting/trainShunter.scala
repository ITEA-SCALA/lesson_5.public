package com.itea.di.v3

package shunting {
  class PointSwitcher() { println("1. Point Switcher") }
  class TrainCarCoupler() { println("2. Train Car Coupler") }
  class TrainShunter(pointSwitcher: PointSwitcher, trainCarCoupler: TrainCarCoupler) { println("3. Train Shunter (1+2)") }
}
