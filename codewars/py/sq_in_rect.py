"""
Kata: Rectangle into Squares
"""

def sqInRect(lng, wdth):
    if lng == wdth:
        return None

    squares = []
    while wdth > 0:
        cnt = int(lng / wdth)
        rem = lng % wdth
        for i in range(0, cnt):
            squares.append(wdth)
        lng = wdth
        wdth = rem
    return squares

assert sqInRect(5, 3) == [3, 2, 1, 1]