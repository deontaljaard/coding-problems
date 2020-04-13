/*
Kata: Counting Duplicates

Details:
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
*/

function duplicateCount(text) {
    let chars = text.toLowerCase().split("");
    let seen = new Set();
    let duplicates = new Set();
    for (var i = 0; i < chars.length; i++) {
        if (seen.has(chars[i])) duplicates.add(chars[i]);
        else seen.add(chars[i]);
    }
    return duplicates.size;
}

function duplicateCount2(text) {
    const tracker = {}
    text.toLowerCase().split('').forEach(c => tracker[c] >= 1 ? tracker[c]++ : tracker[c] = 1);    
    return Object.keys(tracker).filter(c => tracker[c] > 1).length;
}

console.assert(duplicateCount2('aabb') == 2, 'should be 2');
console.assert(duplicateCount2('abcdefabcabA') == 3, 'should be 3');