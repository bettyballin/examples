var markup = '<svg xmlns="http://www.w3.org/2000/svg" width="1" height="1"></svg>';
var imgsrc = 'data:image/svg+xml;base64,' + btoa(unescape(encodeURIComponent(markup)));
var img = new Image(1, 1); // width, height values are optional params 
img.src = imgsrc;
document.body.appendChild(img);