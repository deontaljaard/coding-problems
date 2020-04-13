/*
Kata: Rectangle into Squares
*/

function sqInRect(lng, wdth) {
    if (lng == wdth) return null;

    if (lng < wdth)
        lng, wdth = wdth, lng;

    const squares = [];
    while (wdth > 0) {
        let quotient = Math.floor(lng / wdth);
        let rem = lng % wdth;
        Array(quotient).fill().forEach(_ => squares.push(wdth));
        lng = wdth;
        wdth = rem;
    }
    return squares;
}

console.log(sqInRect(5, 3))
console.assert(sqInRect(5, 3) === [3, 2, 1, 1])