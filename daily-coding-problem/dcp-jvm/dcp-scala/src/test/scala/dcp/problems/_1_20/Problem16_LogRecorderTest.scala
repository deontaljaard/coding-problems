package dcp.problems._1_20

import Problem16_LogRecorder.OrderLog
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable.ArrayBuffer

class Problem16_LogRecorderTest extends AnyFlatSpecLike with Matchers {

  "LogRecorder" should "add an order id it's log" in {
    val orderLog = new OrderLog(5)
    orderLog.record(1)
    orderLog.record(2)
    orderLog.record(3)
    orderLog.log should be(ArrayBuffer(1, 2, 3))
    orderLog.getLast(1) should be(3)
    orderLog.record(4)
    orderLog.record(5)
    orderLog.getLast(1) should be(5)
    orderLog.record(6)
    orderLog.record(7)
    orderLog.record(8)
    orderLog.log should be(ArrayBuffer(4, 5, 6, 7, 8))
    orderLog.getLast(1) should be(8)
    orderLog.getLast(5) should be(4)

  }

}
