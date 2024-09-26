
   var newHeight = /* calculate the new height somehow */;
   window.parent.postMessage({
     'messageType': 'setHeight',
     'height': newHeight
   }, '*'); // Replace '*' with the parent domain for added security
   
