// Create a fragment
let fragment = document.createDocumentFragment();
let text = document.createTextNode('Hello, Alice!');
fragment.appendChild(text);

// Create output div
let output = document.createElement('div');
output.appendChild(fragment);

// Add to alice element
$('#alice').html($(output).html());