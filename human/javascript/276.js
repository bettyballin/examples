// Create a basic HTML layout
let layout = "<h1>Hello World!</h1><p>This is a test.</p>";

// Create a new div element
let div = document.createElement("div");

// Set the id of the div to "test"
div.id = "test";

// Append the div to the body of the document
document.body.appendChild(div);

// Set the innerHTML of the div to the layout
document.getElementById("test").innerHTML = layout;