"""
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all
the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was
[3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
"""


def product_of_array(ints):
    N = len(ints)

    cumulative_product = 1
    product_prefix = [1] * N
    for i, elem in enumerate(ints):
        cumulative_product *= elem
        product_prefix[i] = cumulative_product

    cumulative_product = 1
    product_prefix_reverse = [1] * N
    for i, elem in enumerate(ints[::-1]):
        cumulative_product *= elem
        product_prefix_reverse[i] = cumulative_product
    product_prefix_reverse = product_prefix_reverse[::-1]

    result = [0] * len(ints)
    for i in range(len(ints)):
        if i == 0:
            result[i] = product_prefix_reverse[i + 1]
        elif i == len(ints) - 1:
            result[i] = product_prefix[i - 1]
        else:
            result[i] = product_prefix[i - 1] * product_prefix_reverse[i + 1]

    return result


def product_of_array_2(ints):
    result = [0] * len(ints)
    for i in range(len(ints)):
        product = 1
        for j in range(len(ints)):
            product *= ints[j] if i != j else 1
        result[i] = product
    return result


assert (product_of_array([1, 2, 3, 4, 5]) == [120, 60, 40, 30, 24])
assert (product_of_array([3, 2, 1]) == [2, 3, 6])
assert (product_of_array_2([1, 2, 3, 4, 5]) == [120, 60, 40, 30, 24])
assert (product_of_array_2([3, 2, 1]) == [2, 3, 6])
