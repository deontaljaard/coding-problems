/*
Kata: Rectangle into Squares
*/

package rectIntoSquares

func SquaresInRect(lng int, wdth int) []int {
    if lng == wdth {
		return []int{}
	}

	if (lng > wdth) {
		wdth, lng = lng, wdth
	}

	squares := []int{}
	for lng > 0 {
		var quot = wdth / lng
		var rem = wdth % lng
		tmp := make([]int, quot)
		for i := range tmp {
			tmp[i] = lng
		}
		squares = append(squares, tmp...)
		wdth = lng
		lng = rem
	}
	return squares
}