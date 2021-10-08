package com.itea.di.v1

import com.softwaremill.macwire.wire

/*
 * ***
 * создаем систему для железнодорожного вокзала
 * цель - вызвать метод подготовки (загрузки, сборки вагонов) и отправки следующего поезда
 */

class PointSwitcher()
class TrainCarCoupler()
class TrainShunter(pointSwitcher: PointSwitcher,
                   trainCarCoupler: TrainCarCoupler)

class CraneController()
class TrainLoader(craneController: CraneController,
                  pointSwitcher: PointSwitcher)

class TrainDispatch()

class TrainStation(trainShunter: TrainShunter,
                   trainLoader: TrainLoader,
                   trainDispatch: TrainDispatch) {

  def prepareAndDispatchNextTrain() = {
    println("метод подготовки (загрузки, сборки вагонов) и отправки следующего поезда")
  }
}

/*
 * Используя чистый Scala:
 * Cake pattern
 * Это - внедрение зависимостей ручного DI
 * ***
 * Для этого требуется немного больше набора текста
 * но при выполнении действий вручную вы свободны от каких-либо ограничений, которые может наложить фреймворк
 * (и следовательно достигается большая гибкость)
 *
 * Преимущества ручного DI:
 * ...
 * Определение зависимостей с помощью 'val' имеет один недостаток:
 * если зависимость используется до инициализации, она будет использоваться 'null' при ссылке (потому что 'val' вычисляются сверху вниз).
 */
object TrainStation1 extends App {
  val pointSwitcher = new PointSwitcher()
  val trainCarCoupler = new TrainCarCoupler()
  val trainShunter = new TrainShunter(pointSwitcher, trainCarCoupler)

  val craneController = new CraneController()
  val trainLoader = new TrainLoader(craneController, pointSwitcher)

  val trainDispatch = new TrainDispatch()

  val trainStation = new TrainStation(trainShunter, trainLoader, trainDispatch)

  trainStation.prepareAndDispatchNextTrain()
}
/*
 * Этот недостаток ('null' при ссылке) можно исправить с помощью 'lazy val' которые определяются по запросу, и правильный порядок инициализации будет рассчитан автоматически.
 */
object TrainStation2 extends App {
  lazy val pointSwitcher = new PointSwitcher()
  lazy val trainCarCoupler = new TrainCarCoupler()
  lazy val trainShunter = new TrainShunter(pointSwitcher, trainCarCoupler)

  lazy val craneController = new CraneController()
  lazy val trainLoader = new TrainLoader(craneController, pointSwitcher)

  lazy val trainDispatch = new TrainDispatch()

  lazy val trainStation = new TrainStation(trainShunter, trainLoader, trainDispatch)

  trainStation.prepareAndDispatchNextTrain()
}


// ////////////////////////////

/*
 * Использование MacWire:
 * ***
 * 'wire' - это макрос в Scala, который генерирует код создания нового экземпляра
 * После использования MacWire код становится проще
 *
 * Если добавляется новая зависимость или изменяется порядок параметров, код связывания объект-граф изменять не нужно макрос позаботится об этом.
 * (только при внедрении нового сервиса, его необходимо добавить в список)
 */
object TrainStation3 extends App {
  lazy val pointSwitcher   = wire[ PointSwitcher ]
  lazy val trainCarCoupler = wire[ TrainCarCoupler ]
  lazy val trainShunter    = wire[ TrainShunter ]

  lazy val craneController = wire[ CraneController ]
  lazy val trainLoader     = wire[ TrainLoader ]
  lazy val trainDispatch   = wire[ TrainDispatch ]

  lazy val trainStation    = wire[ TrainStation ]

  trainStation.prepareAndDispatchNextTrain()
}