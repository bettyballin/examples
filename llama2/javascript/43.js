// Create a new HTML document
var doc = document.implementation.createHTMLDocument("");

// Your code here
const output = "Hello, World!"; // Define output variable
const link = doc.createElement("a");
link.innerHTML = output;
doc.body.appendChild(link);

// Log the resulting HTML
console.log(doc.documentElement.outerHTML);