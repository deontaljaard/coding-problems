/*
Kata: Simple Pig Latin

Details:
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
*/

package pigLatin

import "strings"

func PigIt(s1 string) string {
    s := strings.Split(s1, " ")
    for i, word := range s {
        if len(word) > 1 {
            chars := []rune(word)
            s[i] = string(chars[1:]) + string(chars[0:1]) + "ay"
        }
    } 
    return strings.Join(s, " ")
}