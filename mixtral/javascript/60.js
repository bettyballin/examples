$(document).ready(function() {
    var myIframe = document.getElementById("my-iframe-id");

    if (myIframe && myIframe.contentWindow) {
        myIframe.addEventListener('load', function () {
            try {
                const doc = this.contentDocument || this.contentWindow.document;

                // Check for the existence of target element
                var targetElement = doc ? doc.getElementById("my-target-id") : null;

                if (targetElement)
                    targetElement.innerHTML = "Found it!";
            } catch(e){
              console.error('Error accessing iFrame content:', e);
          }
        });
     }
});