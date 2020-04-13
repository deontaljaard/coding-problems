"""
Kata: You're a square!

Details:
You like building blocks. You especially like building blocks that are squares. And what you even like more, is to arrange them into a square of square building blocks!

However, sometimes, you can't arrange them into a square. Instead, you end up with an ordinary rectangle! Those blasted things! If you just had a way to know, whether you're currently working in vain… Wait! That's it! You just have to check if your number of building blocks is a perfect square.
Task

Given an integral number, determine if it's a square number
"""

from math import sqrt

def is_square(n):
    if n < 0:
        return False
    return True if sqrt(n) % 1 == 0 else False

assert not is_square(-1)
assert is_square(0)
assert not is_square(3)
assert is_square(25)