
   var img = document.querySelector('img');
   img.onerror = function() {
       // The image might have failed to load due to mixed content blocking
       // Inform the user or adjust the page behavior accordingly
   };
   
