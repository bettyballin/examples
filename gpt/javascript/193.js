
   (function() {
       var originalOpen = XMLHttpRequest.prototype.open;
       XMLHttpRequest.prototype.open = function(method, url, async, user, pass) {
           // Modify the url here
           if (
