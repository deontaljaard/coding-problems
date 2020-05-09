"""
This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
"""
import time


def function():
    print("Executing function...")


def schedule(fun, delay):
    delay_in_seconds = delay / 1000
    print(f"Function will get executed after {delay_in_seconds} seconds...")
    time.sleep(delay_in_seconds)
    fun()


schedule(function, 3000)
