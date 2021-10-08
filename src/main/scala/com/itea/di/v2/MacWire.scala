package com.itea.di.v2

import com.softwaremill.macwire.wire

/*
 * Использование неявных параметров
 * ***
 * Такое использование 'implicit' имеет 2-недостатка
 * 1. это навязчиво так как вы должны пометить список параметров конструктора каждого подключаемого класса как 'implicit'
 *    нежелательно и может заставить человека, читающего код, задаться вопросом почему параметры неявны...
 * 2. 'implicit' используются во многих других местах Scala для иных целей.
 *    добавление большого количества implicit-ов может привести к путанице.
 *    (однако такой стиль может подходить для некоторых других случаев использования)
 */
class PointSwitcher() { println("1. Point Switcher") }
class TrainCarCoupler() { println("2. Train Car Coupler") }
class TrainShunter(implicit pointSwitcher: PointSwitcher,
                   trainCarCoupler: TrainCarCoupler) { println("3. Train Shunter (1+2)") }

class CraneController() { println("4. Crane Controller") }
class TrainLoader(implicit craneController: CraneController,
                  pointSwitcher: PointSwitcher) { println("5. Train Loader (1+4)") }

class TrainDispatch() { println("6. Train Dispatch") }

class TrainStation(implicit trainShunter: TrainShunter,
                   trainLoader: TrainLoader,
                   trainDispatch: TrainDispatch) {

  def prepareAndDispatchNextTrain() = {
    print("метод подготовки (загрузки, сборки вагонов) и отправки следующего поезда")
  }
}

object TrainStation1 extends App {
  implicit lazy val pointSwitcher = new PointSwitcher
  implicit lazy val trainCarCoupler = new TrainCarCoupler
  implicit lazy val trainShunter = new TrainShunter

  implicit lazy val craneController = new CraneController
  implicit lazy val trainLoader = new TrainLoader

  implicit lazy val trainDispatch = new TrainDispatch

  implicit lazy val trainStation = new TrainStation

  trainStation.prepareAndDispatchNextTrain()
}

object TrainStation2 extends App {
  implicit lazy val pointSwitcher   = wire[ PointSwitcher ]
  implicit lazy val trainCarCoupler = wire[ TrainCarCoupler ]
  implicit lazy val trainShunter    = wire[ TrainShunter ]

  implicit lazy val craneController = wire[ CraneController ]
  implicit lazy val trainLoader     = wire[ TrainLoader ]

  // обратите внимание на 'def' вместо 'lazy val'
  implicit def trainDispatch        = wire[ TrainDispatch ]

  // станции разделяют все услуги, кроме отправления поездов, для которых создается новый экземпляр при каждом использовании
  implicit lazy val trainStationEast = wire[ TrainStation ]
  implicit lazy val trainStationWest = wire[ TrainStation ]

  println( " >> Train East-Station" + trainStationEast.prepareAndDispatchNextTrain() )
  println( " >> Train West-Station" + trainStationWest.prepareAndDispatchNextTrain() )
}

// ////

//package shunting {
//  trait ShuntingModule {
//    lazy val pointSwitcher = wire[PointSwitcher]
//    lazy val trainCarCoupler = wire[TrainCarCoupler]
//    lazy val trainShunter = wire[TrainShunter]
//  }
//}