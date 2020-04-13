/*
Kata: Simple Pig Latin

Details:
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
*/

function pigIt(str) {
    return str.split(" ").map(word => {
        if(word.match(/[0-9A-Za-z]/)) return word.substring(1) + word.substring(0, 1) + "ay";
        else return word;
    }).join(" ");
}

console.assert(pigIt("How are you doing?") == "owHay reaay ouyay oing?day")
console.assert(pigIt("Pig latin is cool") == "igPay atinlay siay oolcay")

