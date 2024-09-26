// Create a sample xmlHTTP object with a responseText property
var xmlHTTP = {
  responseText: '<p>This is a sample response.</p>'
};

// Create a sample element with the id 'response'
var responseElement = document.createElement('div');
responseElement.id = 'response';
document.body.appendChild(responseElement);

// Original code
var div = document.createElement('div');
div.innerHTML = xmlHTTP.responseText;
document.getElementById('response').appendChild(div);