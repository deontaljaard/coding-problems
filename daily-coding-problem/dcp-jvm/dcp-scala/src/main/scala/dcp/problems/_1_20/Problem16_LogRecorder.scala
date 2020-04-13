package dcp.problems._1_20

import scala.collection.mutable.ArrayBuffer

object Problem16_LogRecorder {

  class OrderLog(size: Int) {
    var log: ArrayBuffer[Int] = ArrayBuffer()

    def record(id: Int): Unit = {
      log += id
      if (log.size > size)
        log = log.drop(1)
    }

    def getLast(index: Int): Int = log.reverse(index - 1)
  }

}
