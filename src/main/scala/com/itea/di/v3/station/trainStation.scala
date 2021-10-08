package com.itea.di.v3

package station {
  import com.itea.di.v3.loading.TrainLoader
  import com.itea.di.v3.shunting.TrainShunter

  class TrainDispatch() { println("6. Train Dispatch") }

  class TrainStation(trainShunter: TrainShunter, trainLoader: TrainLoader, trainDispatch: TrainDispatch) {
    def prepareAndDispatchNextTrain() { println("7. Train Station: метод подготовки (загрузки, сборки вагонов) и отправки следующего поезда") }
  }
}
