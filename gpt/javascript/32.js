
   window.addEventListener('message', function(event) {
     // Optional: Check event.origin here to make sure the message is from a trusted domain
     if (event.data && event.data.messageType === 'setHeight') {
       var iframe = document.getElementById('my_frame');
       iframe.style.height = event.data.height + 'px';
     }
   }, false);
   
