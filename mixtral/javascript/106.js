// Import DOMPurify library
const DOMPurify = require('dompurify');

// Define the text to be sanitized
let $text = "<script>alert('XSS')</script><h1>Hello World!</h1>";

// Sanitize the text
let sanitizedText = DOMPurify.sanitize($text);

// Create a new div element
let myDiv = document.createElement('div');
myDiv.id = 'myDiv';

// Set the sanitized text as the innerHTML of the div
myDiv.innerHTML = sanitizedText;

// Append the div to the body
document.body.appendChild(myDiv);