
   const iframe = document.createElement('iframe');
   iframe.style.display = 'none';
   document.body.appendChild(iframe);
   const cleanWindow = iframe.contentWindow; // this window object is clean

   const originalSplit = cleanWindow.String.prototype.split;
   document.body.removeChild(iframe);
   
