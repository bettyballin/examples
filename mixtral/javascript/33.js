// Decode hex encoded value
const CURRENT_VALUE = "%3Cscript%3Ealert('XSS')%3C/script%3E"; // example value
const decodedValue = decodeURIComponent(CURRENT_VALUE);

// HTML Encode the CURRENT_VALUE
let htmlEncodedValue = document.createElement('textarea');
htmlEncodedValue.innerText = decodedValue;

// JavaScript encode any user input that is used in dynamic script execution
const jsEscapedValue = JSON.stringify(decodedValue);

document.getElementById("myElement").innerHTML = htmlEncodedValue.value;