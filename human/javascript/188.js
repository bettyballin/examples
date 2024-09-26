// Create a new HTML document
var html = document.implementation.createHTMLDocument('');

// Create a button element
var button = html.createElement('button');

// Define a click handler for the button
button.onclick = function() {
  console.log('Button clicked!');
};

// Add the button to the HTML document
html.body.appendChild(button);

// Get the button element and click it
document.getElementsByTagName('button')[0].click();