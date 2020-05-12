"""
This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
"""


def longest_substring(k, s):
    def find(rem, count, longest, acc):
        if not rem:
            return longest
        elif rem[0] in acc:
            return find(rem[1:], count, longest, acc + rem[0])
        elif rem[0] not in acc and count < k:
            return find(rem[1:], count + 1, longest, acc + rem[0])
        else:
            return find(acc[-1] + rem, 0, max_len(longest, acc), "")  # reset

    return find(s, 0, "", "") if k > 1 else s[0]


def max_len(s1, s2):
    return s1 if len(s1) > len(s2) else s2


assert longest_substring(2, 'abcba') == 'bcb'
assert longest_substring(3, 'abbbbcda') == 'abbbbc'
assert longest_substring(1, 'abcbbbaaaaaaaaaabbcbbadd') == 'a'
