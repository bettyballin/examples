var ALPHABET_SIZE = 'Z'.charCodeAt(0) - 'A'.charCodeAt(0) + 1;

var encrypted = vigenere(false, "B", "Zaphod Breeblebox");
document.body.innerHTML += '<div>' + encrypted + '</div>';
var decrypted = vigenere(true, "B", encrypted);
document.body.innerHTML += '<div>' + decrypted + '</div>';

function vigenere(decrypt, key, text) {
    key = toJustUppercase(key);
    text = toJustUppercase(text);
  
    var textOffset = 0;
    // iterate over all characters, performing the function on each of them
    return text.replace(/[A-Z]/g, function(textChar) {
        var keyChar = key[textOffset++ % key.length];
        var cryptedChar = substituteCharacter(decrypt, keyChar, textChar);
        return cryptedChar;
    });
}

function substituteCharacter(decrypt, keyChar, textChar) {
    var keyIndex = charToABCIndex(keyChar);
    if (decrypt) {
        // create the opposite of the encryption key index
        keyIndex = ALPHABET_SIZE - keyIndex;
    }
    
    var textIndex = charToABCIndex(textChar);

    // the actual Vigenere substitution, the rest is just indexing and conversion
    var substitutedIndex = (textIndex + keyIndex) % ALPHABET_SIZE;
      
    var substitutedChar = abcIndexToChar(substitutedIndex);
    return substitutedChar;
}

function toJustUppercase(text) {
    return text.toUpperCase().replace(/[^A-Z]/g, '')
}

function charToABCIndex(charValue) {
    return charValue.charCodeAt(0) - 'A'.charCodeAt(0);
}

function abcIndexToChar(index) {
    return String.fromCharCode(index + 'A'.charCodeAt(0));
}