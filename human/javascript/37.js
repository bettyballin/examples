// create a div element
var somediv = document.createElement('div');

// set the innerHTML of the div
var name = 'John';
somediv.innerHTML= '<p>Hello, '+name+'</p>';

// add the div to the body of the document
document.body.appendChild(somediv);