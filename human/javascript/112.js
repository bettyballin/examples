var xhr = new XMLHttpRequest();
xhr.onload = function() {
    var json = xhr.responseText;                         // Response
    json = json.replace(/^[^(]*\(([\S\s]+)\);?$/, '$1'); // Turn JSONP in JSON
    json = JSON.parse(json);                             // Parse JSON
    console.log(json);                                   // Log the parsed json
};
// Example:
var data = 'Example: appended to the query string..';
xhr.open('GET', 'http://domain/getjson?data=' + encodeURIComponent(data));
xhr.send();