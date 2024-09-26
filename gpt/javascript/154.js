
   // In the iframe:
   window.addEventListener("message", receiveMessage, false);

   function receiveMessage(event) {
     if (event.origin !== "http://expected-origin.com") {
       return; // Ignore messages from unexpected sources
     }
     var topUrl = event.data; // The top page URL sent by the parent
   }

   // In the top page:
   iframe.contentWindow.postMessage(window.location.href, "http://iframe-origin.com");
   ``
