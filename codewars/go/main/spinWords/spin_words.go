/*
Kata: Stop gninnipS My sdroW!

Details:
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
*/

package spinWords

import "strings"

func SpinWords(sentence string) string {
	s := strings.Split(sentence, " ")
	for i, word := range s {
		if len(word) >= 5 {
			s[i] = reverse(word)
		}
	}
	return strings.Join(s[:], " ") 
}

func reverse(word string) string {
	data := []rune(word)
	reversed := []rune{}

	for i := len(data) - 1; i >= 0; i-- {
		reversed = append(reversed, data[i])
	}

	return string(reversed)
}