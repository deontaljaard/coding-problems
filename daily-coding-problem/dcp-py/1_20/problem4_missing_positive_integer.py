"""
This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words,
find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers
as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
"""


def missing_positive_integer(arr):
    s = set(arr)
    for i in range(1, len(arr) + 1):
        if i not in s:
            return i
    return len(arr) + 1


assert missing_positive_integer([]) == 1
assert missing_positive_integer([3, 4, -1, 1]) == 2
assert missing_positive_integer([1, 2, 0]) == 3
assert missing_positive_integer([-5, -2, 0]) == 1
assert missing_positive_integer([1, 2, 3, 4, 6, 7, 8]) == 5
