var xmlHTTP = new XMLHttpRequest();
xmlHTTP.open("GET", "https://example.com/xml", true);
xmlHTTP.onload = function() {
  var xmlDoc = xmlHTTP.responseXML;
  if (xmlDoc) {
    var divContent = xmlDoc.getElementsByTagName('div')[0].textContent; // or innerText for IE8-
    document.getElementById('response').innerText = divContent;
  }
};
xmlHTTP.send();