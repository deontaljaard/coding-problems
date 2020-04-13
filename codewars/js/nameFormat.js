/*
Kata: Format a string of names like 'Bart, Lisa & Maggie'.

Details: 
Given: an array containing hashes of names

Return: a string formatted as a list of names separated by commas except for the last two names, which should be separated by an ampersand.
*/

function list(names) {
    const nameStr = names.map(obj => obj.name).join(", ");
    if (names.length > 1) {
        const idxOfComma = nameStr.lastIndexOf(',');
        return nameStr.substring(0, idxOfComma) + ' &' + nameStr.substring(idxOfComma + 1);
    }
    return nameStr;
}

function list2(names) {
    const last = names.pop() || {name: ''};
    const nameStr = names.map(o => o.name).join(', ');
    return nameStr ? `${nameStr} & ${last.name}` : last.name;
}


console.assert(list2([{name: 'Bart'},{name: 'Lisa'},{name: 'Maggie'},{name: 'Homer'},{name: 'Marge'}]), 'Bart, Lisa, Maggie, Homer & Marge');
console.assert(list2([{name: 'Bart'},{name: 'Lisa'}]), 'Bart & Lisa');
console.assert(list2([{name: 'Bart'}]), 'Bart');