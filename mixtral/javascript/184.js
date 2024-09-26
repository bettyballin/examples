function caesarCipher(inputText) {
  const shift = 3;

  // Convert text to lowercase
  let outputText = inputText.toLowerCase();

  // Initialize an empty string
  var ciphertext = "";

  for (let i = 0, len = outputText.length; i < len; ++i) {
    const charCode = outputText[i].charCodeAt(0);

    if ((charCode >= "a".charCodeAt(0)) &&
        (charCode <= "z".charCodeAt(0)))
      ciphertext += String.fromCharCode((charCode - 97 + shift) % 26 + 97);

    else
      // If the character is not a letter append it as-is
      ciphertext += outputText[i];

  }

  return ciphertext;
}

console.log(caesarCipher("Hello, World!"));