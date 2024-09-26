const hexString = "0caf649feee4953d87bf903ac1176c45e028df16"

let hexCharacterPairs = hexString.match(/../g);

let bytes = hexCharacterPairs.map(e => parseInt(e, 16));

let binaryStringSymbols = bytes.map(e => String.fromCharCode(e));

let binaryString = binaryStringSymbols.join("");

let base64 = btoa(binaryString);

console.log(base64);

console.log(btoa("0caf649feee4953d87bf903ac1176c45e028df16".match(/../g).map(e => String.fromCharCode(parseInt(e, 16))).join("")));