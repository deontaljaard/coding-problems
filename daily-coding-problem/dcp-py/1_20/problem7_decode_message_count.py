"""
This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
"""


def decode_message_count(msg):
    if len(msg) <= 1:
        return 1
    elif 1 <= int(msg[:2]) <= 26:
        return decode_message_count(msg[1:]) + decode_message_count(msg[2:])
    else:
        return decode_message_count(msg[1:])


def in_bounds(msg):
    return 1 <= int(msg[:2]) <= 26


assert decode_message_count('111') == 3  # aaa, ak, ka
assert decode_message_count('113') == 3  # aaa, am, ma
assert decode_message_count('1') == 1  # a
