var xhr = new XMLHttpRequest();
xhr.open("GET", "https://google.com", true);
xhr.addEventListener('load', function (ev) {
    console.log(this.responseText);  
});
xhr.send();

// Added true as third parameter to make the request async
// Changed http to https to avoid mixed content error