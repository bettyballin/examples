document.getElementById("ciphers").addEventListener('click', (event) => {

    // Get references to both textareas
  const inputTextArea = document.getElementById("input");
  const outputTextArea = document.getElementById("output");

  if (event.target && event.target.id === "caesar")

      // Set the value of the second textarea
    outputTextArea.value = caesarCipher(inputTextArea.value);

});

// assuming caesarCipher function is defined somewhere
function caesarCipher(text) {
  // implement your caesar cipher logic here
  return text;
}