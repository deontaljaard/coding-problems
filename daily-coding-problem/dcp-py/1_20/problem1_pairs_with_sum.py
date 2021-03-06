"""
This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
"""


def pairs_with_sum(arr, k):
    comps = set()
    for e in arr:
        if e in comps:
            return True
        comps.add(k - e)
    return False


assert (pairs_with_sum([10, 15, 3, 7], 17))  # 10 + 7
assert (pairs_with_sum([12, 4, 6, 9, 15, 13, 7], 25))  # 12 + 13
