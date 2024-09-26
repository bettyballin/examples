function ordA(a) {
    return a.charCodeAt(0) - 65;
}

function vigenereCipher(a, b, decode) {
    return String.fromCharCode(((ordA(a) + (decode ? 26 - ordA(b) : ordA(b))) % 26 + 65));
}

console.log(vigenereCipher('A', 'B', false));
console.log(vigenereCipher('A', 'B', true));