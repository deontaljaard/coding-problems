"""
This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

Reference: https://www.dailycodingproblem.com/blog/how-to-pick-a-random-element-from-an-infinite-stream/
"""
import random


def random_element(stream):
    random_val = None
    for i, elem in enumerate(stream):
        if i == 0:
            random_val = elem
        elif random.randint(1, i + 1) == 1:
            random_val = elem
    return random_val


big_stream = [i for i in range(1, 100)]

print(random_element(big_stream))
print(random_element(big_stream))
print(random_element(big_stream))
print(random_element(big_stream))
print(random_element(big_stream))
