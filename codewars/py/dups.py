"""
Kata: Counting Duplicates

Details:
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
"""

def duplicate_count(text):
    count = text.lower().count
    return len([count(c) for c in set(text.lower()) if count(c) > 1])

def duplicate_count_2(text):
    count = {}
    for c in text.lower():
        if count.get(c):
            count[c] = count[c] + 1
        else:
            count[c] = 1
    return len([value for key, value in count.items() if value > 1])

assert duplicate_count_2("aabb") == 2
assert duplicate_count("aabbcccdeff") == 4