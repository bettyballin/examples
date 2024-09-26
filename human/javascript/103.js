function getPageandSelectedTextIndex() {
  // Your function code here
  console.log("Function called!");
}

// Create a button element
var button = document.createElement("button");
button.innerHTML = "Click me";
button.onclick = getPageandSelectedTextIndex;

// Add the button to the page
document.body.appendChild(button);