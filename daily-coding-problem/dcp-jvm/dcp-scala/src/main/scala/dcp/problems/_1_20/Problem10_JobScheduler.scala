package dcp.problems._1_20

import java.util.{Timer, TimerTask}

/**
 * This problem was asked by Apple.
 *
 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */

object Problem10_JobScheduler {

  def execute(n: Long)(f: => Unit): Unit = {
    val timer = new Timer()
    val task = new TimerTask {
      override def run(): Unit = {
        f
        timer.cancel()
      }
    }
    timer.schedule(task, n)
  }

  def main(args: Array[String]): Unit = {
    val delay = execute(3000) _
    delay {
      println("Hello, did I win? :)")
    }
    execute(2000) {
      println("I am going to be first!")
    }
  }
}
