/*
Kata: Stop gninnipS My sdroW!

Details:
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
*/

function spinWords(sentence) {
    const words = sentence.split(" ")
    const spinned = []
    for (var i = 0; i < words.length; i++) {
        if (words[i].length >= 5) spinned.push(words[i].split("").reverse().join(""));
        else spinned.push(words[i]);
    }
    return spinned.join(" ")
}

function spinWords2(sentence) {
    return sentence.split(' ')
        .reduce((acc, word) => {
            word.length >= 5 ? acc.push(word.split('').reverse().join('')) : acc.push(word);
            return acc;
        }, [])
        .join(' ');
}

console.assert(spinWords2("Stop spinning this around!") == "Stop gninnips this !dnuora")