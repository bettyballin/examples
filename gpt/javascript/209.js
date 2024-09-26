
var xhttp = new XMLHttpRequest();
xhttp.open('POST', 'log/', true);
xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
xhttp.send('uniqueCode=' + uniqueCode + '&timestamp=' + timestamp);

