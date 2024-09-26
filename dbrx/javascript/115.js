function caesarCipher(text, shift) {
  var result = "";

  for (var i = 0; i < text.length; i++) {
    var charCode = text.charCodeAt(i);

    if (charCode >= 65 && charCode <= 90) {
      result += String.fromCharCode((charCode - 65 + shift) % 26 + 65);
    } else if (charCode >= 97 && charCode <= 122) {
      result += String.fromCharCode((charCode - 97 + shift) % 26 + 97);
    } else {
      result += text.charAt(i);
    }
  }

  return result;
}

function convert() {
  var x = document.getElementById("inputText").value;

  if (document.getElementById('caesar').checked) {
    x = caesarCipher(x, 3);
  } else if (document.getElementById('reverse').checked) {
    x = x.split("").reverse().join("");
  }

  document.getElementById("outputText").value = x;
}


html
<input type="text" id="inputText">
<input type="radio" id="caesar" name="cipher">
<label for="caesar">Caesar Cipher</label>
<input type="radio" id="reverse" name="cipher">
<label for="reverse">Reverse</label>
<button onclick="convert()">Convert</button>
<input type="text" id="outputText">