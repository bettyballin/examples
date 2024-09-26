function checkInputLength(inputText) {
  var maxLength = 10; // Set your desired maximum character limit

  if (inputText.length > maxLength) {
    alert("Input exceeds " + maxLength + " characters.");

    return false;
  }

  return true;
}

// Example usage:
var inputText = prompt("Enter some text:");
checkInputLength(inputText);