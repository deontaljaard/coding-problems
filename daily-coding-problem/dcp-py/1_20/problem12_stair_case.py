"""
This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function
that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive
integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
"""


def stair_case(steps, n):
    if n == 0:
        return 1

    count = 0
    for step in steps:
        if n - step >= 0:
            count += stair_case(steps, n - step)
    return count


assert stair_case([1], 4) == 1
assert stair_case([1, 2], 4) == 5
assert stair_case([1, 3, 5], 5) == 5
