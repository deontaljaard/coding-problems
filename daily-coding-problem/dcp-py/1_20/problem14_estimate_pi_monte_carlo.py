"""
This problem was asked by Google.

The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x2 + y2 = r2.
"""

import random


def estimate_pi(num_tests):
    count = 0
    for _ in range(num_tests):
        if in_circle(random.uniform(0.0, 1.0), random.uniform(0.0, 1.0)):
            count += 1
    return 4 * count / num_tests


def in_circle(x, y):
    return x * x + y * y <= 1.0


iterations = 1000000
assert round(estimate_pi(iterations), 3) == 3.141
