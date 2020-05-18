"""
This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish
this, with the following API:

    record(order_id): adds the order_id to the log
    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible.
"""


class LogRecorder:

    def __init__(self, size):
        self.size = size
        self.log = []

    def record(self, order_id):
        if len(self.log) == self.size:
            self.log = self.log[1:] + [order_id]
        else:
            self.log.append(order_id)

    def get_last(self, i):
        return self.log[-i]


recorder = LogRecorder(3)
recorder.record(1)
recorder.record(2)
recorder.record(3)
assert recorder.log == [1, 2, 3]
recorder.record(4)
assert recorder.log == [2, 3, 4]

assert recorder.get_last(1) == 4
assert recorder.get_last(2) == 3
assert recorder.get_last(3) == 2
