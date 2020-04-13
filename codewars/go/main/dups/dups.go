/*
Kata: Counting Duplicates

Details:
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
*/

package dups

import "strings"

func DuplicateCount(s1 string) int {
    tracker := make(map[string]int)
    for _, c := range strings.ToLower(s1) {
        if tracker[string(c)] >= 1 {
            tracker[string(c)]++
        } else {
            tracker[string(c)] = 1
        }
    }

    count := 0
    for _, v := range tracker {
        if v > 1 {
            count++
        }
    }
    
    return count  
}

func DuplicateCount2(s1 string) int {
    tracker := make(map[rune]int)
    count := 0
    for _, c := range strings.ToLower(s1) {
        tracker[c]++

        if tracker[c] == 2 {
            count++
        }
    }
    return count
}