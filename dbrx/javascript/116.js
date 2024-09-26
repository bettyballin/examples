function caesarCipher(str, shift) {
  const alphabetLength = 26;
  
  // Convert the input string to lowercase and remove any non-alphabetic characters.
  str = str.toLowerCase().replace(/[^a-z]/g, '');
  
  let encryptedStr = '';
  
  for (let i = 0; i < str.length; ++i) {
    const charCode = str.charCodeAt(i);
    
    // Check if the character is a letter. If it's not skip to the next iteration.
    if (charCode >= 'a'.charCodeAt(0) && charCode <= 'z'.charCodeAt(0)) {
      let newCharCode;
      
      // Calculate the encrypted character code based on its position in the alphabet and shift value.
      const shiftedCharIndex = ((charCode - 97 + shift) % alphabetLength);
      if (shiftedCharIndex < 0)
        newCharCode = 'z'.charCodeAt(0) + shiftedCharIndex + 1;
      else
        newCharCode = 97 + shiftedCharIndex;

      encryptedStr += String.fromCharCode(newCharCode);
    }
  }

  return encryptedStr;
}

// Test the function
console.log(caesarCipher("hello", 1)); // "ifmmp"
console.log(caesarCipher("ifmmp", -1)); // "hello"