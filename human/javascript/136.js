var x = new XMLHttpRequest();
x.open('GET', '/possiblymodified.js');
x.onload = function() {
    console.log(x.responseText); // Full source code here....
};
x.send();