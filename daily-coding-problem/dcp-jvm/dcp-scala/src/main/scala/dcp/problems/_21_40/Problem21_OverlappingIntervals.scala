package dcp.problems._21_40

/**
 * This problem was asked by Snapchat.
 *
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum
 * number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

object Problem21_OverlappingIntervals {

  type Interval = (Int, Int)

  def solution(intervals: Array[Interval]): Int = {
    val startTimes = intervals.map(_._1)
    val endTimes = intervals.map(_._2)

    var numRooms, roomsReq = 0
    for(time <- Range(startTimes.min, endTimes.max)) {
      if(startTimes.contains(time))
        numRooms += 1
        roomsReq = math.max(roomsReq, numRooms)
      if(endTimes.contains(time))
        numRooms -= 1
    }

    roomsReq
  }
}
